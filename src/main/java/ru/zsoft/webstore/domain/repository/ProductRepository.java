package ru.zsoft.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import ru.zsoft.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	void updateStock(String productId, long numOfUnits);
	List<Product> getProductByCategory(String category);
	List<Product> getProductByFilter(Map<String, List<String>> params);
	Product getProductById(String productId);
	void addProduct(Product product);
}
