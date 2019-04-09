package ru.zsoft.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import ru.zsoft.webstore.domain.Product;
import ru.zsoft.webstore.domain.repository.ProductRepository;
import ru.zsoft.webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Product> getAllProducts() {
		Map<String, Object> params = new HashMap<>();
		List<Product> result = jdbcTemplate.query("select * from Products", params, new ProductMapper());
		return result;
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
	         product.setImageSource(rs.getString("IMAGE_SRC"));
	         
	         return product;
		}
		
	}

	@Override
	public void updateStock(String productId, long numOfUnits) {
		String sql = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :units_in_stock WHERE id= :id";
		Map<String, Object> params = new HashMap<>();
		params.put("units_in_stock", numOfUnits);
		params.put("id", productId);
		jdbcTemplate.update(sql, params);		
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY = :catergory";
		Map<String, Object> params = new HashMap<>();
		params.put("catergory", category);
		System.out.println(category);
		List<Product> result = jdbcTemplate.query(sql, params, new ProductMapper());		
		return result;
	}

	@Override
	public List<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY IN (:categories) AND MANUFACTURER IN (:brands)";
		return jdbcTemplate.query(sql, filterParams, new ProductMapper());
	}

	@Override
	public Product getProductById(String productId){
		System.out.println(productId);
		String sql = "SELECT * FROM PRODUCTS WHERE ID = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", productId);
		try {
			return jdbcTemplate.queryForObject(sql, params, new ProductMapper());
		} catch (Exception e) {
			throw new ProductNotFoundException(productId);
		}		
	}

	@Override
	public void addProduct(Product product) {
		  String SQL = "INSERT INTO PRODUCTS (ID, "
	               + "NAME, DESCRIPTION, UNIT_PRICE, MANUFACTURER,"
	               + "CATEGORY, CONDITION, UNITS_IN_STOCK, UNITS_IN_ORDER,"
	               + "DISCONTINUED) "
	               + "VALUES (:id, :name, :desc, :price, :manufacturer, "
	               + ":category, :condition, :inStock, :inOrder, :discontinued)";  
	         
	         Map<String, Object> params = new HashMap<>();
	         params.put("id", product.getProductId());  
	         params.put("name", product.getName());  
	         params.put("desc", product.getDescription());  
	         params.put("price", product.getUnitPrice());  
	         params.put("manufacturer", product.getManufacturer());  
	         params.put("category", product.getCategory());  
	         params.put("condition", product.getCondition());  
	         params.put("inStock", product.getUnitsInStock());  
	         params.put("inOrder", product.getUnitsInOrder());  
	         params.put("discontinued", product.isDiscontinued());  

	         jdbcTemplate.update(SQL, params);
	}
	
}
