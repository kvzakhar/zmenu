package ru.zsoft.webstore.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ru.zsoft.webstore.domain.Product;

@Component
public class UnitsInStockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;		
		
		if(product.getUnitPrice() != null 
				&& new BigDecimal(1000).compareTo(product.getUnitPrice()) <=0 && product.getUnitsInStock() >99) {
			errors.rejectValue("unitsInStock", "ru.zsoft.webstore.validator.unitsInStockValidator.message");
		}		
	}

}
