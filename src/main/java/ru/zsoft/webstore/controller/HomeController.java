package ru.zsoft.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping
	public String welcome(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("greeting", "Welcome to webStore");
		model.addAttribute("tagline", "The only web store");
		redirectAttributes.addFlashAttribute("greeting", "Welcome to webStore");
		redirectAttributes.addFlashAttribute("tagline", "The only web store");
		return "redirect:welcome/greeting";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		System.out.println("/welcome/greeting");
	   return "welcome";
	}

}
