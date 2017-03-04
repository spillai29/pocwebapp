package com.microservice.webui;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,@RequestParam(value = "userid", required = false) String userid,@RequestParam(value = "pword", required = false) String pword) {
		
		 
		System.out.println("In login");
		//Map modelmap=model.asMap();
		//String username=(String)modelmap.get("username");
		System.out.println("testing form"+userid+" "+pword);
		
		 final String uri = "http://localhost:8083/UserMgmtMS/rest/validateUser?userid="+userid+"&pword="+pword;
	     
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    System.out.println("esult="+result);
		    //model.addAttribute("logedinuser", userid );
		    if (result.equals("Valid"))
		    	{
		    	model.addAttribute("logedinuser", userid );
				return "telecom";
				}
				else
				{
					model.addAttribute("logedinuser", "you are not logged in" );
				return "Erroruser";}
		
		//return "telecom";
	}
	
	@RequestMapping(value = "/telecomsell", method = RequestMethod.GET)
	public String telecomsell(Model model,@RequestParam(value = "provider", required = false) String provider,@RequestParam(value = "type", required = false) String type,@RequestParam(value = "packname", required = false) String packname) {
		/*Map<String,Object> modelMap = model.asMap();
		String logedinuser=(String)modelMap.get("logedinuser");
		System.out.println("logged in user "+logedinuser);
		if(logedinuser==null)
		{
			model.addAttribute("telecomerror", "Invalid User.Please Log in" );
			return "Erroruser";
		}*/
		 
		System.out.println("In telecom");
		//Map modelmap=model.asMap();
		//String username=(String)modelmap.get("username");
		System.out.println("testing form"+provider+" "+packname);
		
		 final String uri = "http://localhost:8080/gs-rest-service/shopping/donatecellpack?provider="+provider+"&type="+type+"&packname="+packname;
	     
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    System.out.println(result);
		    model.addAttribute("telecomresponse",result);
		    return "telecom";
		
	}
	
	@RequestMapping(value = "/telecombuy", method = RequestMethod.GET)
	public String telecombuy(Model model,@RequestParam(value = "provider", required = false) String provider,@RequestParam(value = "type", required = false) String type,@RequestParam(value = "packname", required = false) String packname) {
		
		 
		System.out.println("In telecom");
		//Map modelmap=model.asMap();
		//String username=(String)modelmap.get("username");
		System.out.println("testing form"+provider+" "+packname);
		
		 final String uri = "http://localhost:8080/gs-rest-service/shopping/requestcellpack?provider="+provider+"&packname="+packname;
	     
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		   
		    System.out.println(result);
		  // if(result equals("success")) 
		    model.addAttribute("telecomresponse",result);
		return "telecom";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model,@RequestParam(value = "username", required = false) String username,@RequestParam(value = "pword", required = false) String pword) {
		
		 
		System.out.println("Registration");
			return "registration";
	}
	
	
	@RequestMapping(value = "/userregistration", method = RequestMethod.GET)
	public String registeruser(Model model,@RequestParam(value = "username", required = false) String username,@RequestParam(value = "pword", required = false) String pword,@RequestParam(value = "userid", required = false) String userid) {
		
		 
		System.out.println("In user registration");
		//Map modelmap=model.asMap();
		//String username=(String)modelmap.get("username");
		System.out.println("testing user registrationform"+username+" "+userid);
		
		//final String uri = "http://localhost:8086/UserMgmtMS/rest/createUser?userid="+username+"&pword="+pword+"&userid="+userid;
		final String uri = "http://localhost:8083/UserMgmtMS/rest/createUser?";
	     
	
		
		    RestTemplate restTemplate = new RestTemplate();
		/*    User user=new User();
		    user.setUserId(userid);
		    user.setUserName(username);
		    user.setPword(pword);
		    		
		    String returns = restTemplate.getForObject(uri, String.class);
		   // String  returns = restTemplate.postForObject(uri, user, String.class);
System.out.println("after calling user creation"+returns);
		   // model.addAttribute("serverTime", result );*/
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("userid", userid);
		map.add("username", username);
		map.add("pword", pword);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> returns = restTemplate.postForEntity( uri, request , String.class );

		System.out.println("after calling user creation"+returns);
		
		HttpStatus statuscode=returns.getStatusCode();
		String response=returns.getBody();
		    if (response.equals("success"))
		    {
		    	model.addAttribute("msgcreation", "User Created Successfully.Please Log in as new user" );
				return "home";
		    }
		    else
		    { model.addAttribute("msgcreation", "User Creation Failed.Please try again" );
		    	return "Erroruser";
		    }
		
		//return "telecom";
	}	
	
	
}
