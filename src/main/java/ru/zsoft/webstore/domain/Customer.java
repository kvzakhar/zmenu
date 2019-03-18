package ru.zsoft.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = -3453404972826714037L;
	
	private String customerId;
	private String name;
	private String address;
	private long noOfOrdersMade;
	
	public Customer() {
		
	}
	
	public Customer(String id, String name, String address, long numOfOrders) {
		this.customerId = id;
		this.name = name;
		this.address = address;
		this.noOfOrdersMade = numOfOrders;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}
	

}
