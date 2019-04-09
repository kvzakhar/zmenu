package ru.zsoft.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ru.zsoft.webstore.domain.Cart;
import ru.zsoft.webstore.domain.CartItem;
import ru.zsoft.webstore.service.ProductService;

public class CartMapper implements RowMapper<Cart>{

	private CartItemMapper cartItemMapper;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public CartMapper(NamedParameterJdbcTemplate template, ProductService productService) {
		this.jdbcTemplate = template;
		this.cartItemMapper = new CartItemMapper(productService);
	}
	
	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id = rs.getString("ID");
		Cart cart = new Cart(id);
		String SQL = String.format("select * from cart_item where cart_id = '%s'", id);
		List<CartItem> cartItems = jdbcTemplate.query(SQL, cartItemMapper);
		cart.setCartItems(cartItems);
		return cart;
	}

}
