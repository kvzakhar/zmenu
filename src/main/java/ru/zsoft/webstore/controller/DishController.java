package ru.zsoft.webstore.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
	
	public static void main(String[] args) {
		System.out.println(11^2+1);
	}
	
	private String getWeekDay() {
		LocalDate now =  LocalDate.now();
		int dayM = now.getDayOfMonth();
		int dw = now.getDayOfWeek().getValue();
		//System.out.println(dayM / 7+ " " + dw);		
		return (dayM / 7+ 1)+""+dw;
	}
	
	@Autowired
	private DishService dishService;
	
	@RequestMapping("/dishes")
	public String list(Model model) {
		model.addAttribute("dishes", dishService.getDishesByWeekDay(getWeekDay()));
		return "dishes";
	}	
	
	@GetMapping("/dishes/today")
	public String listByCategory(Model model, @RequestParam("weekDay") String weekDay) {
		model.addAttribute("dishes", dishService.getDishesByWeekDay(weekDay));
		return "/fragment/dish-items";
	}
	
	

}
