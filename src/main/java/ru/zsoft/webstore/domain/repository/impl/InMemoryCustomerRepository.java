package ru.zsoft.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.zsoft.webstore.domain.Customer;
import ru.zsoft.webstore.domain.Product;
import ru.zsoft.webstore.domain.repository.CustomerRepository;
import ru.zsoft.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	private List<Customer> customers = new ArrayList<>();
	
	public InMemoryCustomerRepository() {
		customers.add(new Customer("1", "John", "Moscow", 2));
		customers.add(new Customer("2", "Bob", "Moscow", 4));
		customers.add(new Customer("3", "Stew", "Moscow", 3));
	}

	private static class ProductMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Product product = new Product();
	         product.setProductId(rs.getString("ID"));
	         product.setName(rs.getString("NAME"));
	         product.setDescription(rs.getString("DESCRIPTION"));
	         product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
	         product.setManufacturer(rs.getString("MANUFACTURER"));
	         product.setCategory(rs.getString("CATEGORY"));
	         product.setCondition(rs.getString("CONDITION"));
	         product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
	         product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
	         product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
	         return product;
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		String sql = "select * from customers";
		return customers;
	}

}
