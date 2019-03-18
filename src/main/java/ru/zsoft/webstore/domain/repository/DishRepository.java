package ru.zsoft.webstore.domain.repository;

import java.util.List;

import ru.zsoft.webstore.domain.Dish;

public interface DishRepository {
	List<Dish> getAllDishes();
	List<Dish> getDishesByCategory(String category);
	List<Dish> getDishesByWeekDay(int week, int day);
}
