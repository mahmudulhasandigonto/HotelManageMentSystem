package com.exam.hotel.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class GrandioseDailyBasis {

	private LocalDate date;
	private double subTotal;
	private double discount;
	private double grandTotal;

	public GrandioseDailyBasis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GrandioseDailyBasis(LocalDate date, double subTotal, double discount, double grandTotal) {
		super();
		this.date = date;
		this.subTotal = subTotal;
		this.discount = discount;
		this.grandTotal = grandTotal;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

}
