package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// a controller method to show the initial HTML form
	@RequestMapping("showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// a controller method to process the HTML form
	@RequestMapping("processForm")
	public String processForm() {
		return "helloworld";
	}

	// a controller method to read form data
	// and add data to the model
	@RequestMapping("processFormV2")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from the HTML form
		String name = request.getParameter("studentName");

		// convert data to all caps
		name = name.toUpperCase();

		// create the message
		String result = "Yoo! " + name;

		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("processFormV3")
	public String processFormV3(@RequestParam("studentName") String name, Model model) {

		// convert data to all caps
		name = name.toUpperCase();

		// create the message
		String result = "Yoo! " + name;

		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
