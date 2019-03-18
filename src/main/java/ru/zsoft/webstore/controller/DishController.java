package ru.zsoft.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.zsoft.webstore.service.DishService;

@Controller
public class DishController {
	
	@Autowired
	private DishService dishService;
	
	@RequestMapping("/dishes")
	public String list(Model model) {
		model.addAttribute("dishes", dishService.getAllDishes());
		return "dishes";
	}	
	
	@GetMapping("/dishes/today")
	public String listByCategory(Model model, @RequestParam("weekDay") String weekDay) {
		model.addAttribute("dishes", dishService.getDishesByWeekDay(weekDay));
		return "/fragment/dish-items";
	}

}
