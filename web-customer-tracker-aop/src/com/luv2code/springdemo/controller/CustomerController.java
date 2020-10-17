package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {

		// get customers from service
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model model) {
		// create model attribute to bind the form data
		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// save the customer using service
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {

		Customer customer = customerService.getCustomer(customerId);

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model model) {

		customerService.deleteCustomer(customerId);

		return "redirect:/customer/list";
	}

	@GetMapping("search")
	public String searchCustomer(@RequestParam("searchName") String searchName, Model model) {
		List<Customer> customers = customerService.searchName(searchName);

		model.addAttribute("customers", customers);

		return "list-customers";
	}

}
