package ru.zsoft.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ru.zsoft.webstore.domain.Product;
import ru.zsoft.webstore.domain.repository.impl.InMemoryProductRepository;

public interface ProductService {

	void updateAllStock();
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
}
