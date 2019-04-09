package ru.zsoft.webstore.service;

import java.util.List;
import java.util.Map;

import ru.zsoft.webstore.domain.Product;

public interface ProductService {

	void updateAllStock();
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	List<Product> getProductByFilter(Map<String, List<String>> params);
	Product getProductById(String productId);
	void addProduct(Product product);
}
