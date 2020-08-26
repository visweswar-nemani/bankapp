package bankapp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bankapp.api.BaseResponse.status;
import bankapp.api.SignupResponse;
import bankapp.api.TransactionRequest;
import bankapp.api.TransactionResponse;
import bankapp.api.UserLoginRequest;
import bankapp.api.UserLoginResponse;
import bankapp.api.UserLogoutRequest;
import bankapp.api.userSignupInfo;
import bankapp.service.ITransactionService;
import bankapp.service.LoginService;
import bankapp.service.LoginServiceImplementation;
import bankapp.service.SignupServiceImplementation;
import bankapp.service.TransactionServiceImpl;

@Controller
public class WelcomePageController {
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private SignupServiceImplementation signupService;
	
	@Autowired
	private LoginServiceImplementation loginService; 
	
	@Autowired
	private ITransactionService transactionServiceImpl;
	
	@RequestMapping("/")
	public String homePage(@ModelAttribute("userInfo") userSignupInfo userInfo) {
		//logger.debug("home page called");
		return "welcome";		
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		//logger.debug("home page called");
		return "login";		
	}
	
	@RequestMapping("/signup")
	public String signup( @Valid @ModelAttribute("userInfo") userSignupInfo userInfo, BindingResult result,ModelMap model) {
		SignupResponse signupResponse = new SignupResponse();
		System.out.println("input is "+ userInfo +"   "+result.getErrorCount());
		if(result.hasErrors()) {
			System.out.println("issue in form");
			result.getAllErrors();
			return "welcome";
		}	
		signupResponse= signupService.userSignup(userInfo);
		if(signupResponse.getStatus().equals(status.FAILURE)) {
			logger.debug("failed case");
			model.addAttribute("result", "signup failed !!. pleaser retry");
			return "welcome";
		}
		logger.info("signup response -->{}",signupResponse);
		model.addAttribute("message", "Account created!! please Login");
		return "redirectPage";
		
	}
	
	@RequestMapping("/auth")	
	public String login(UserLoginRequest loginRequest,HttpServletRequest request,ModelMap model) {
		UserLoginResponse response = new UserLoginResponse();
		logger.debug("login creds {}",loginRequest.toString());	
		//logger.debug("the paremaeters are : {}   and pass {} and session status {}",req.getParameter("username"),req.getParameter("password"),req.getSession().getId());
		response = loginService.userLoginValidation(loginRequest);
		
		
		logger.debug("login creds {}",response.toString());
		if(response.getStatus().equals(status.FAILURE)) {
			model.addAttribute("loginMessage","Username/password not correct");
			return "login";
		}
		model.addAttribute("userDetails",response.getUsername());
		//req.getSession().invalidate();
		return "txnResponse";
		
	}
	
	
	@RequestMapping("/userHomePage")
	public String userHomePage(String username,ModelMap model) {
		logger.info("details required for user -->{}",username);
		model.addAttribute("userDetails",loginService.getAccountinfo(username));
		return "userHomePage";
	}
	 
	
	@RequestMapping("/logout")
	public String logout( UserLogoutRequest  logoutRequest,ModelMap model) {
		logger.info("active user is -->{}",logoutRequest.toString());
		model.addAttribute("message","you have successfully logged out");
		
		return "redirectPage";
		
	}
	
	
	@RequestMapping("/doTransaction")
	public String doTransaction(TransactionRequest request,ModelMap  model) {
		TransactionResponse response = new TransactionResponse();
		logger.info("details of transaction is {}",request.toString());
		response = transactionServiceImpl.doTransaction(request);
		if(response.getTxn_status().equalsIgnoreCase(status.FAILURE.toString())) {
			model.addAttribute("txnMessage",response.getDescription());
			model.addAttribute("userDetails",request.getUsername());
			return	"txnResponse";	
		}else {
			model.addAttribute("txnMessage","transaction success");
			model.addAttribute("userDetails",request.getUsername());
			return	"txnResponse";				
		}				 
	}
	
	/*
	 * @RequestMapping("/doTest")
	 * 
	 * @ResponseBody public TransactionResponse test(String data){
	 * TransactionResponse response = new TransactionResponse ();
	 * response.setAcc_balance(85623); response.setAccount_id(6523);
	 * response.setDescription("gd"); logger.info("info {} , {}",data,response);
	 * return response;
	 * 
	 * }
	 */

}
