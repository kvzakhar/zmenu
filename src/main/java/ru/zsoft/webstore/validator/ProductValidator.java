package ru.zsoft.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ru.zsoft.webstore.domain.Product;
import ru.zsoft.webstore.exception.ProductNotFoundException;
import ru.zsoft.webstore.service.ProductService;

public class ProductValidator implements ConstraintValidator<ProductId, String> {

	@Autowired
	ProductService productService;
	
	@Override
	public void initialize(ProductId constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		try {
			product = productService.getProductById(value);
		} catch (ProductNotFoundException e) {
			return true;
		}
		if(product != null) {
			return false;
		}
		return true;
	}

}
