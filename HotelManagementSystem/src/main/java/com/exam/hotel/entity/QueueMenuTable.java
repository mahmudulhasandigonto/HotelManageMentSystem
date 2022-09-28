package com.exam.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QueueMenuTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tableNo;
	private long itemCode;
	private String itemName;
	private long unitPrice;
	private int itemquantity;
	private long totalPrice;

	public QueueMenuTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueueMenuTable(int id, String tableNo, long itemCode, String itemName, long unitPrice, int itemquantity,
			long totalPrice) {
		super();
		this.id = id;
		this.tableNo = tableNo;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.itemquantity = itemquantity;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
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

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getItemquantity() {
		return itemquantity;
	}

	public void setItemquantity(int itemquantity) {
		this.itemquantity = itemquantity;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

}
