package ru.zsoft.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import ru.zsoft.webstore.domain.Product;
import ru.zsoft.webstore.domain.repository.ProductRepository;
import ru.zsoft.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repository;
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Override
//	@Transactional
	public void updateAllStock() {
		List<Product> allProducts = repository.getAllProducts();
	
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		
		try {
			allProducts.stream().
			filter(p->{return p.getUnitsInStock() < 500;}).
			peek(p->{System.out.println(p.getUnitsInStock() + " " +p.getManufacturer());}).
			forEach(p->{repository.updateStock(p.getProductId(), p.getUnitsInStock() + 1000);});
			
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			System.err.println(e);
			transactionManager.rollback(transactionStatus);
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> result = repository.getAllProducts();
		System.out.println(result.size());
		return result;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return repository.getProductByCategory(category);
	}

}
