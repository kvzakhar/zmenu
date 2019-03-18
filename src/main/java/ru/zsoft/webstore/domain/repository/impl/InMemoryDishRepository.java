package ru.zsoft.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.zsoft.webstore.domain.Dish;
import ru.zsoft.webstore.domain.repository.DishRepository;

@Repository
public class InMemoryDishRepository implements DishRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Dish> getAllDishes() {
		Map<String, Object> params = new HashMap<>();
		List<Dish> result = jdbcTemplate.query("select * from DISHES", params, new DishMapper());
		return result;
	}
	
	@Override
	public List<Dish> getDishesByCategory(String category) {
		String sql = "SELECT * FROM DISHES WHERE CATEGORY = :catergory";
		Map<String, Object> params = new HashMap<>();
		params.put("catergory", category);
		System.out.println(category);
		List<Dish> result = jdbcTemplate.query(sql, params, new DishMapper());		
		return result;
	}


	@Override
	public List<Dish> getDishesByWeekDay(int week, int day) {
		String sql = "SELECT * FROM DISHES WHERE WEEK_SERVED = :weekServed AND DAY_SERVED = :dayServed";
		Map<String, Object> params = new HashMap<>();
		params.put("weekServed", week);
		params.put("dayServed", day);
		List<Dish> result = jdbcTemplate.query(sql, params, new DishMapper());
		System.out.println("found dishes " + result.size());
		return result;
	}
	
	private static class DishMapper implements RowMapper<Dish>{

		@Override
		public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Dish dish = new Dish();
			 dish.setDishId(rs.getString("ID"));
			 dish.setName(rs.getString("NAME"));
			 dish.setDescription(rs.getString("DESCRIPTION"));
			 dish.setWeight(rs.getBigDecimal("WEIGHT"));
	         dish.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
	         dish.setCategory(rs.getString("CATEGORY"));
	         dish.setWeekServed(rs.getBigDecimal("WEEK_SERVED"));
	         dish.setDayServed(rs.getBigDecimal("DAY_SERVED"));
	         dish.setDiscontinued(rs.getBoolean("DISCONTINUED"));
	         dish.setImageSource(rs.getString("IMAGE_SRC"));
	         
	         return dish;
		}		
	}

}
