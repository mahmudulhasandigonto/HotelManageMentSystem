package com.exam.hotel.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class RestaurantTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_bn")
	@SequenceGenerator(name = "restaurant_bn", initialValue = 6001001, allocationSize = 1, sequenceName = "restaurant_billsqu")
	private Long billNo;
	private String outletName;
	private Double subTotal;
	@Column(name="discount")
	private Double discount=0.0;
	private Double grandTotal;
	private String paymentType;
	private String cardType;
	private String cardReceit;
	private Integer guestRoomNo;
	private String posUser;
	@Column(name = "transactionDate", nullable = false, updatable = false)
	@CreationTimestamp
	private Date transactionDate;
	public RestaurantTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantTransaction(Long billNo, String outletName, Double subTotal, Double discount, Double grandTotal,
			String paymentType, String cardType, String cardReceit, Integer guestRoomNo, String posUser,
			Date transactionDate) {
		super();
		this.billNo = billNo;
		this.outletName = outletName;
		this.subTotal = subTotal;
		this.discount = discount;
		this.grandTotal = grandTotal;
		this.paymentType = paymentType;
		this.cardType = cardType;
		this.cardReceit = cardReceit;
		this.guestRoomNo = guestRoomNo;
		this.posUser = posUser;
		this.transactionDate = transactionDate;
	}
	public Long getBillNo() {
		return billNo;
	}
	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}
	public String getOutletName() {
		return outletName;
	}
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardReceit() {
		return cardReceit;
	}
	public void setCardReceit(String cardReceit) {
		this.cardReceit = cardReceit;
	}
	public Integer getGuestRoomNo() {
		return guestRoomNo;
	}
	public void setGuestRoomNo(Integer guestRoomNo) {
		this.guestRoomNo = guestRoomNo;
	}
	public String getPosUser() {
		return posUser;
	}
	public void setPosUser(String posUser) {
		this.posUser = posUser;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	

}
