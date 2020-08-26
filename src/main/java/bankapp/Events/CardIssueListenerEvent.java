package bankapp.Events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import bankapp.DAO.ISignupDAO;

@Component
public class CardIssueListenerEvent {
	
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	private ISignupDAO signupDAO;
	
	@EventListener
	public void IssueNewCard(NewCardIssueEvent data) {
		
		logger.info("Received new card issue Event {}",data.cardData.toString());
		
		try {
			signupDAO.IssueNewCard(data.cardData);
			
		} catch(Exception e) {
			logger.error("Error in issuing new card  {}",e);
		}
		
	}

}
