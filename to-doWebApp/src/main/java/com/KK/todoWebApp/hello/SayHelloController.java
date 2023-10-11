package com.KK.todoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("Say-Hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What's up?";
	}
	@RequestMapping("say-hello-jsp")
	public String sayHellojsp() {
		return "sayHello";
		
	}
}
