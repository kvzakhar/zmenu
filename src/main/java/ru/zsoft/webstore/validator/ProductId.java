package ru.zsoft.webstore.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy= {ProductValidator.class})
public @interface ProductId {
	String message() default "{ru.zsoft.webstore.ProductId.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
