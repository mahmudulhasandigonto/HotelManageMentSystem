package com.exam.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class RestaurantMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_item")
	@SequenceGenerator(name = "menu_item", initialValue = 1001, allocationSize = 1, sequenceName = "menu_itemSqu")
	private long itemCode;
	private String itemName;
	private long price;

	public RestaurantMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantMenu(long itemCode, String itemName, long price) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}

	public long getItemCode() {
		return itemCode;
	}

	public void setItemCode(long itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
