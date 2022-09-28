package com.exam.hotel.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CheckInRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Check_in")
	@SequenceGenerator(name = "Check_in", initialValue = 4004001, allocationSize = 1, sequenceName = "guest_checkinRecordSqu")
	private Long guestRegNo;
	private String guestName;
	private String guestEmail;
	private String guestPnd;
	private Integer guestAdult;
	private Integer guestChild;
	private String guestNationality;
	private String guestPurpose;
	private String guestCompany;
	private Date guestCheckin;
	private Date guestCheckout;
	private Integer guestStayingDays;
	private String guestRoomName;
	private Integer guestRoomNo;
	private Integer guestPerNight;
	private Double guestTotalRent;
	private Double guestDeposit;
	@Column(name="guestOtherServices")
	private Double guestOtherServices=0.0;
	private String guestPaymentStatus;
	private String guestNote;

	public CheckInRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckInRecord(Long guestRegNo, String guestName, String guestEmail, String guestPnd, Integer guestAdult,
			Integer guestChild, String guestNationality, String guestPurpose, String guestCompany, Date guestCheckin,
			Date guestCheckout, Integer guestStayingDays, String guestRoomName, Integer guestRoomNo,
			Integer guestPerNight, Double guestTotalRent, Double guestDeposit, Double guestOtherServices,
			String guestPaymentStatus, String guestNote) {
		super();
		this.guestRegNo = guestRegNo;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.guestPnd = guestPnd;
		this.guestAdult = guestAdult;
		this.guestChild = guestChild;
		this.guestNationality = guestNationality;
		this.guestPurpose = guestPurpose;
		this.guestCompany = guestCompany;
		this.guestCheckin = guestCheckin;
		this.guestCheckout = guestCheckout;
		this.guestStayingDays = guestStayingDays;
		this.guestRoomName = guestRoomName;
		this.guestRoomNo = guestRoomNo;
		this.guestPerNight = guestPerNight;
		this.guestTotalRent = guestTotalRent;
		this.guestDeposit = guestDeposit;
		this.guestOtherServices = guestOtherServices;
		this.guestPaymentStatus = guestPaymentStatus;
		this.guestNote = guestNote;
	}

	public Long getGuestRegNo() {
		return guestRegNo;
	}

	public void setGuestRegNo(Long guestRegNo) {
		this.guestRegNo = guestRegNo;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public String getGuestPnd() {
		return guestPnd;
	}

	public void setGuestPnd(String guestPnd) {
		this.guestPnd = guestPnd;
	}

	public Integer getGuestAdult() {
		return guestAdult;
	}

	public void setGuestAdult(Integer guestAdult) {
		this.guestAdult = guestAdult;
	}

	public Integer getGuestChild() {
		return guestChild;
	}

	public void setGuestChild(Integer guestChild) {
		this.guestChild = guestChild;
	}

	public String getGuestNationality() {
		return guestNationality;
	}

	public void setGuestNationality(String guestNationality) {
		this.guestNationality = guestNationality;
	}

	public String getGuestPurpose() {
		return guestPurpose;
	}

	public void setGuestPurpose(String guestPurpose) {
		this.guestPurpose = guestPurpose;
	}

	public String getGuestCompany() {
		return guestCompany;
	}

	public void setGuestCompany(String guestCompany) {
		this.guestCompany = guestCompany;
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

	public String getGuestRoomName() {
		return guestRoomName;
	}

	public void setGuestRoomName(String guestRoomName) {
		this.guestRoomName = guestRoomName;
	}

	public Integer getGuestRoomNo() {
		return guestRoomNo;
	}

	public void setGuestRoomNo(Integer guestRoomNo) {
		this.guestRoomNo = guestRoomNo;
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

	public Double getGuestDeposit() {
		return guestDeposit;
	}

	public void setGuestDeposit(Double guestDeposit) {
		this.guestDeposit = guestDeposit;
	}

	public Double getGuestOtherServices() {
		return guestOtherServices;
	}

	public void setGuestOtherServices(Double guestOtherServices) {
		this.guestOtherServices = guestOtherServices;
	}

	public String getGuestPaymentStatus() {
		return guestPaymentStatus;
	}

	public void setGuestPaymentStatus(String guestPaymentStatus) {
		this.guestPaymentStatus = guestPaymentStatus;
	}

	public String getGuestNote() {
		return guestNote;
	}

	public void setGuestNote(String guestNote) {
		this.guestNote = guestNote;
	}

}
