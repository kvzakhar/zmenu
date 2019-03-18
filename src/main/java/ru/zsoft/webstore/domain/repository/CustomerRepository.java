package ru.zsoft.webstore.domain.repository;

import java.util.List;

import ru.zsoft.webstore.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
