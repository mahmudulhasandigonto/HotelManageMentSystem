package com.exam.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_id")
	@SequenceGenerator(name = "room_id", initialValue = 30002001, allocationSize = 1, sequenceName = "room_idSqu")
	private int roomId;
	private String roomName;
	private String roomType;
	private String regularPrice;
	private String promotionalPrice;
	private String floor;
	private int quantity;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int roomId, String roomName, String roomType, String regularPrice, String promotionalPrice,
			String floor, int quantity) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomType = roomType;
		this.regularPrice = regularPrice;
		this.promotionalPrice = promotionalPrice;
		this.floor = floor;
		this.quantity = quantity;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	public String getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(String regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getPromotionalPrice() {
		return promotionalPrice;
	}

	public void setPromotionalPrice(String promotionalPrice) {
		this.promotionalPrice = promotionalPrice;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", roomType=" + roomType + ", regularPrice="
				+ regularPrice + ", promotionalPrice=" + promotionalPrice + ", floor=" + floor + ", quantity="
				+ quantity + "]";
	}

}
