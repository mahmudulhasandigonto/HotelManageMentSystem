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
public class CheckOutTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Check_out")
	@SequenceGenerator(name = "Check_out", initialValue = 5005001, allocationSize = 1, sequenceName = "guest_checkoutSqu")
	private Long voucherNo;
	private Long guestRegNo;
	private Integer guestRoomNo;
	private String guestName;
	private Date guestCheckin;
	private Date guestCheckout;
	private Integer guestStayingDays;
	private Integer guestPerNight;
	private Double guestTotalRent;
	private Double guestOtherServices;
	private Double guestSubTotal;
	private Double guestDeposit;
	private Double guestDiscont;
	private Double guestGrandTotal;
	private Double guestPayment;
	private Double guestChange;
	String posUser;
	@Column(name = "transactionDate", nullable = false, updatable = false)
	@CreationTimestamp
	Date transactionDate;

	public CheckOutTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckOutTransaction(Long voucherNo, Long guestRegNo, Integer guestRoomNo, String guestName,
			Date guestCheckin, Date guestCheckout, Integer guestStayingDays, Integer guestPerNight,
			Double guestTotalRent, Double guestOtherServices, Double guestSubTotal, Double guestDeposit,
			Double guestDiscont, Double guestGrandTotal, Double guestPayment, Double guestChange, String posUser,
			Date transactionDate) {
		super();
		this.voucherNo = voucherNo;
		this.guestRegNo = guestRegNo;
		this.guestRoomNo = guestRoomNo;
		this.guestName = guestName;
		this.guestCheckin = guestCheckin;
		this.guestCheckout = guestCheckout;
		this.guestStayingDays = guestStayingDays;
		this.guestPerNight = guestPerNight;
		this.guestTotalRent = guestTotalRent;
		this.guestOtherServices = guestOtherServices;
		this.guestSubTotal = guestSubTotal;
		this.guestDeposit = guestDeposit;
		this.guestDiscont = guestDiscont;
		this.guestGrandTotal = guestGrandTotal;
		this.guestPayment = guestPayment;
		this.guestChange = guestChange;
		this.posUser = posUser;
		this.transactionDate = transactionDate;
	}

	public Long getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(Long voucherNo) {
		this.voucherNo = voucherNo;
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

	public Date getGuestCheckin() {
		return guestCheckin;
	}

	public void setGuestCheckin(Date guestCheckin) {
		this.guestCheckin = guestCheckin;
	}

	public Date getGuestCheckout() {
		return guestCheckout;
	}

	public void setGuestCheckout(Date guestCheckout) {
		this.guestCheckout = guestCheckout;
	}

	public Integer getGuestStayingDays() {
		return guestStayingDays;
	}

	public void setGuestStayingDays(Integer guestStayingDays) {
		this.guestStayingDays = guestStayingDays;
	}

	public Integer getGuestPerNight() {
		return guestPerNight;
	}

	public void setGuestPerNight(Integer guestPerNight) {
		this.guestPerNight = guestPerNight;
	}

	public Double getGuestTotalRent() {
		return guestTotalRent;
	}

	public void setGuestTotalRent(Double guestTotalRent) {
		this.guestTotalRent = guestTotalRent;
	}

	public Double getGuestOtherServices() {
		return guestOtherServices;
	}

	public void setGuestOtherServices(Double guestOtherServices) {
		this.guestOtherServices = guestOtherServices;
	}

	public Double getGuestSubTotal() {
		return guestSubTotal;
	}

	public void setGuestSubTotal(Double guestSubTotal) {
		this.guestSubTotal = guestSubTotal;
	}

	public Double getGuestDeposit() {
		return guestDeposit;
	}

	public void setGuestDeposit(Double guestDeposit) {
		this.guestDeposit = guestDeposit;
	}

	public Double getGuestDiscont() {
		return guestDiscont;
	}

	public void setGuestDiscont(Double guestDiscont) {
		this.guestDiscont = guestDiscont;
	}

	public Double getGuestGrandTotal() {
		return guestGrandTotal;
	}

	public void setGuestGrandTotal(Double guestGrandTotal) {
		this.guestGrandTotal = guestGrandTotal;
	}

	public Double getGuestPayment() {
		return guestPayment;
	}

	public void setGuestPayment(Double guestPayment) {
		this.guestPayment = guestPayment;
	}

	public Double getGuestChange() {
		return guestChange;
	}

	public void setGuestChange(Double guestChange) {
		this.guestChange = guestChange;
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
