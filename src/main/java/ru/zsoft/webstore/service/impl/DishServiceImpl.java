package ru.zsoft.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zsoft.webstore.domain.Dish;
import ru.zsoft.webstore.domain.repository.DishRepository;
import ru.zsoft.webstore.service.DishService;

@Service
public class DishServiceImpl implements DishService{

	private final DishRepository repository;
	
	@Autowired
	public DishServiceImpl(DishRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Dish> getAllDishes() {
		return repository.getAllDishes();
	}

	@Override
	public List<Dish> getDisheshByCategory(String category) {
		return repository.getDishesByCategory(category);
	}

	@Override
	public List<Dish> getDishesByWeekDay(String weekDay) {
		Integer date = Integer.parseInt(weekDay);
		int week = date / 10;
		int day = date - week * 10;
		System.out.println("param=" + weekDay + " week " + week +  " day " + day);
		return repository.getDishesByWeekDay(week, day);
	}

}
