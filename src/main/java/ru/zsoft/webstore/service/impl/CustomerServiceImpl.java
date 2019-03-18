package ru.zsoft.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zsoft.webstore.domain.Customer;
import ru.zsoft.webstore.domain.repository.CustomerRepository;
import ru.zsoft.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return repository.getAllCustomers();
	}

}
