package com.exam.hotel.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class OtherServicesRecord {

	@Id
	private Long billNo;
	private Long guestRegNo;
	private Integer guestRoomNo;
	private String guestName;
	private String outletName;
	private Double grandTotal;
	private String paymentStatus;
	@Column(name = "ddate", nullable = false, updatable = false)
	@CreationTimestamp
	private Date servicDate;
	private String posUser;

	public OtherServicesRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtherServicesRecord(Long billNo, Long guestRegNo, Integer guestRoomNo, String guestName, String outletName,
			Double grandTotal, String paymentStatus, Date servicDate, String posUser) {
		super();
		this.billNo = billNo;
		this.guestRegNo = guestRegNo;
		this.guestRoomNo = guestRoomNo;
		this.guestName = guestName;
		this.outletName = outletName;
		this.grandTotal = grandTotal;
		this.paymentStatus = paymentStatus;
		this.servicDate = servicDate;
		this.posUser = posUser;
	}

	public Long getBillNo() {
		return billNo;
	}

	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}

	public Long getGuestRegNo() {
		return guestRegNo;
	}

	public void setGuestRegNo(Long guestRegNo) {
		this.guestRegNo = guestRegNo;
	}

	public Integer getGuestRoomNo() {
		return guestRoomNo;
	}

	public void setGuestRoomNo(Integer guestRoomNo) {
		this.guestRoomNo = guestRoomNo;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getServicDate() {
		return servicDate;
	}

	public void setServicDate(Date servicDate) {
		this.servicDate = servicDate;
	}

	public String getPosUser() {
		return posUser;
	}

	public void setPosUser(String posUser) {
		this.posUser = posUser;
	}

	

}
