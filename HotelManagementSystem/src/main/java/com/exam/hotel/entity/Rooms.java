package com.exam.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rooms {

	@Id
	private int roomNo;
	private String roomName;
	private String roomType;
	private String roomStatus;
	private String roomFloor;
	private String note;

	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rooms(int roomNo, String roomName, String roomType, String roomStatus, String roomFloor, String note) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.roomFloor = roomFloor;
		this.note = note;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomFloor() {
		return roomFloor;
	}

	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
