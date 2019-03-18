package ru.zsoft.webstore.domain.repository;

import java.util.List;

import ru.zsoft.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	void updateStock(String productId, long numOfUnits);
	List<Product> getProductByCategory(String category);
}
