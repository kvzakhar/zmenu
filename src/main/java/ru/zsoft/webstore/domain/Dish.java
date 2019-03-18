package ru.zsoft.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dish implements Serializable {

	private static final long serialVersionUID = 3678107792576131001L;

	private String dishId;
	private String name;
	private BigDecimal unitPrice;
	private BigDecimal weight;
	private String description;
	private String category;
	private BigDecimal dayServed;
	private BigDecimal weekServed;
	private boolean discontinued;
	private String imageSource;

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public Dish() {
	}

	public Dish(String dishId, String name, BigDecimal unitPrice) {
		this.dishId = dishId;
		this.name = name;
		this.unitPrice = unitPrice;
	}	
	
	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}	

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public BigDecimal getDayServed() {
		return dayServed;
	}

	public void setDayServed(BigDecimal dayServed) {
		this.dayServed = dayServed;
	}

	public BigDecimal getWeekServed() {
		return weekServed;
	}

	public void setWeekServed(BigDecimal weekServed) {
		this.weekServed = weekServed;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (dishId == null) {
			if (other.dishId != null)
				return false;
		} else if (!dishId.equals(other.dishId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishId == null) ? 0 : dishId.hashCode());
		return result;
	}
}