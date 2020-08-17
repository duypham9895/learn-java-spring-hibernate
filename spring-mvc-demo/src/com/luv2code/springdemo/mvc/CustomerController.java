package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// add an init binder... to convert trim input Strings
	// remove leading and trailing whitespace
	// resolve issue for out validation

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {

		// create a customer object
		Customer customer = new Customer();

		// add customer object to the model
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

		System.out.println("Last name = " + customer.getLastName());

		System.out.println("Binding result = " + bindingResult);

		System.out.println("\n\n\n\n\n");

		if (bindingResult.hasErrors()) {
			return "customer-form";
		}

		return "customer-confirmation";
	}
}
