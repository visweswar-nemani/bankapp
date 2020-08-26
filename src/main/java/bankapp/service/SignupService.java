package bankapp.service;

import java.security.NoSuchAlgorithmException;import java.sql.Timestamp;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bankapp.Generator;
import bankapp.PasswordHash;
import bankapp.DAO.AccountData;
import bankapp.DAO.CardData;
import bankapp.DAO.ISignupDAO;
import bankapp.DAO.SignupData;
import bankapp.Events.NewCardIssueEvent;
import bankapp.api.AccontCreationResponse;
import bankapp.api.AccountCreateRequest;
import bankapp.api.AccountType;
import bankapp.api.BaseResponse.status;
import bankapp.api.CardCreateRequest;
import bankapp.api.CardStatus;
import bankapp.api.CardType;
import bankapp.api.SignupResponse;
import bankapp.api.userSignupInfo;

@Service
public class SignupService implements SignupServiceImplementation,ApplicationEventPublisherAware{
	
	 private static Logger logger = LogManager.getLogger();

	@Autowired
	private ISignupDAO signupDAO;
	
	private ApplicationEventPublisher applicationEventPublisher;
	
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO Auto-generated method stub
		this.applicationEventPublisher=applicationEventPublisher;
	}

	
	
	@Override
	public SignupResponse userSignup(userSignupInfo userSignupInfo) {
		// TODO Auto-generated method stub
		
		SignupResponse response  =  new SignupResponse();		
		AccountCreateRequest request =  new AccountCreateRequest();		
		AccontCreationResponse acc_Response = new AccontCreationResponse();
		SignupData profileResponse = new SignupData();
		
		try
		{
			profileResponse = signupDAO.saveUserProfile(prepareUserSignupData(userSignupInfo));
			
		} catch(Exception e ) {
			logger.error("user profile saving failed --->{}",e);
			response.setStatus(status.FAILURE);
			return response;
		}
		/*
		 * profileId = signupDAO.getProfileIdByEmail(userSignupInfo.getEmail());
		 * logger.info("the profile id of above user is : {}",profileId);
		 */
		if(profileResponse != null) {
			request.setProfile_id(profileResponse);
			request.setAccount_type(AccountType.SAVINGS.toString());  //hard coded , need to set
			acc_Response = createUserAccount(request);
			response.setFirst_name(profileResponse.getFirst_name());
			response.setLast_name(profileResponse.getLast_name());
			if(acc_Response.getStatus().equals(status.SUCCESS)) {
				response.setAcc_balance(acc_Response.getAcc_balance());
				response.setAcc_number(acc_Response.getAcc_number());
				response.setAcc_type(acc_Response.getAcc_type());
				response.setStatus(status.SUCCESS);
				
			}		
		} else {
			response.setStatus(status.FAILURE);
		}
		
		logger.info(" account created --> {}",response.toString());
		return response;
	 
	}

	@Override
	public AccontCreationResponse createUserAccount(AccountCreateRequest request) {
		// TODO Auto-generated method stub
		AccountData accountData = new AccountData();
		AccontCreationResponse response = new AccontCreationResponse();
		CardCreateRequest cardRequest; 
		accountData.setAcc_id(new Generator().accountNumberGenerator()); 
		accountData.setSignupData(request.getProfile_id());
		accountData.setAcc_type(request.getAccount_type());
		accountData.setAcc_balance(0); // initial balance will be zero
		accountData.setCard_status(CardStatus.NOT_ISSUED.toString()); // initial default status
		accountData.setAcc_created_time(new Timestamp(System.currentTimeMillis()));
		accountData.setAcc_updated_time(new Timestamp(System.currentTimeMillis()));
		logger.info("the  details before creating account :  {}",accountData.toString());
		try {
			response = signupDAO.createAccount(accountData);
			logger.info(" account created --> {}",response);
		} catch(Exception e) {
			logger.error("error while creating account");
			response.setStatus(status.FAILURE);
		}
		logger.info("account created :  {}",accountData.toString());
		if(response.getStatus().equals(status.SUCCESS)) {
			cardRequest = new CardCreateRequest();
			cardRequest.setAccount_number(accountData);
			IssueNewCard(cardRequest);
			
		}
		// debit card yet to be prepared
		return response;
	}
	
	public SignupData prepareUserSignupData(userSignupInfo userSignupInfo) {
		
		SignupData signupData = new SignupData();
		signupData.setFirst_name(userSignupInfo.getFirst_name());
		signupData.setLast_name(userSignupInfo.getLast_name());
		signupData.setAddress(userSignupInfo.getAddress());
		signupData.setCity(userSignupInfo.getCity());
		signupData.setCountry(userSignupInfo.getCountry());
		signupData.setEmail(userSignupInfo.getEmail());
		signupData.setId_name(userSignupInfo.getId_name());
		signupData.setId_number(userSignupInfo.getId_number());
		//signupData.setProfile_id(1);
		try {
			signupData.setPassword(new PasswordHash().passwordhash(userSignupInfo.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			logger.error("password not set due to :    "+e);
		}
		logger.debug("the value is {}",userSignupInfo.getPhone());
		logger.debug("the form of phone number is {}",userSignupInfo.getPhone());
		signupData.setPhone(userSignupInfo.getPhone());
		signupData.setState(userSignupInfo.getState());
		signupData.setUsername(userSignupInfo.getUsername());
		signupData.setZip(userSignupInfo.getZip());  // convert zip to int
		signupData.setCreated_time(new Timestamp(System.currentTimeMillis()));
		signupData.setUpdated_time(new Timestamp(System.currentTimeMillis()));
		
		return signupData;
	}
	
	public int toCheck(String value) {
		return value.length();
	}
	
	public void IssueNewCard(CardCreateRequest request) {
		CardData cardData = new CardData();
		cardData.setAcc_id(request.getAccount_number());
		cardData.setCard_id(new Random().nextInt(100000000));//set card id generator and check the number before issuing
		cardData.setCard_status(CardStatus.ACTIVE.toString());
		cardData.setCard_type(CardType.MASTERCARD.toString());
		cardData.setCreated_time(new Timestamp(System.currentTimeMillis()));
		cardData.setCvv(new Random().nextInt(999)); // cvv generator
		cardData.setUpdated_time(new Timestamp(System.currentTimeMillis()));
		cardData.setValidity(new Timestamp(System.currentTimeMillis())); // modify to 3 years of created time
		logger.info("card Data prepared {}",cardData);
		applicationEventPublisher.publishEvent(new NewCardIssueEvent(this, cardData));	
	}
	


}
