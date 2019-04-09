package ru.zsoft.webstore.service;

import ru.zsoft.webstore.domain.Cart;
import ru.zsoft.webstore.dto.CartDto;

public interface CartService {

	void create(CartDto cartDto);

	Cart read(String cartId);

	void update(String cartId, CartDto cartDto);

	void delete(String id);

	void addItem(String cartId, String productId);

	void removeItem(String cartId, String productId);
}
