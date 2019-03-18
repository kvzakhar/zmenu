package ru.zsoft.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.zsoft.webstore.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public String getAllCostomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}

}
