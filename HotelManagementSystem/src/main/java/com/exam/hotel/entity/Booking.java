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
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id")
	@SequenceGenerator(name = "booking_id", initialValue = 2002001, allocationSize = 1, sequenceName = "booking_idsqu")
	private Long bookId;
	private String guestName;
	private String guestEmail;
	private Integer adult;
	private Integer child;
	private Date checkind;
	private Date checkOut;
	private String roomType;
	private String nationality;
	@Column(name = "bookingSysdate", nullable = false, updatable = false)
	@CreationTimestamp
	private Date bookingDate;
	private Date modifyDate;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Long bookId, String guestName, String guestEmail, Integer adult, Integer child, Date checkind,
			Date checkOut, String roomType, String nationality, Date bookingDate, Date modifyDate) {
		super();
		this.bookId = bookId;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.adult = adult;
		this.child = child;
		this.checkind = checkind;
		this.checkOut = checkOut;
		this.roomType = roomType;
		this.nationality = nationality;
		this.bookingDate = bookingDate;
		this.modifyDate = modifyDate;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
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

	public Integer getAdult() {
		return adult;
	}

	public void setAdult(Integer adult) {
		this.adult = adult;
	}

	public Integer getChild() {
		return child;
	}

	public void setChild(Integer child) {
		this.child = child;
	}

	public Date getCheckind() {
		return checkind;
	}

	public void setCheckind(Date checkind) {
		this.checkind = checkind;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


}
