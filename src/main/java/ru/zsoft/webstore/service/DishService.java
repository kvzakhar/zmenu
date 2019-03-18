package ru.zsoft.webstore.service;

import java.util.List;

import ru.zsoft.webstore.domain.Dish;

public interface DishService {

	List<Dish> getAllDishes();
	List<Dish> getDisheshByCategory(String category);
	List<Dish> getDishesByWeekDay(String weekDay);
}
