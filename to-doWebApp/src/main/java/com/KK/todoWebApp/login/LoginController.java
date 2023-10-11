package com.KK.todoWebApp.login;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	//private Logger logger= LoggerFactory.getLogger(getClass());
	@RequestMapping(value="login-jsp", method=RequestMethod.GET)
	public String gotoLoginPage() {//@RequestParam String name, ModelMap model
	
	/*	model.put("name", name);
    	logger.debug("Request param is {}", name);
		logger.info("I want this to be printed at info level");
		logger.warn("I want this to be printed at warn level");
		System.out.println("Request Param is: "+ name);
	*/
		return "login";
	}
	@RequestMapping(value="login-jsp", method=RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, @RequestParam String Password, ModelMap model) {
		model.put("name", name);
		return "Welcome";
	}
}
