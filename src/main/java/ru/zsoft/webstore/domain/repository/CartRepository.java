package ru.zsoft.webstore.domain.repository;

import ru.zsoft.webstore.domain.Cart;
import ru.zsoft.webstore.dto.CartDto;

public interface CartRepository {

	void create(CartDto cartDto);

	Cart read(String id);

	void update(String id, CartDto cartDto);

	void delete(String id);

	void addItem(String cartId, String productId);

	void removeItem(String cartId, String productId);

}
