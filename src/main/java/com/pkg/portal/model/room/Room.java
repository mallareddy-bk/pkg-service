/**
 * 
 */
package com.pkg.portal.model.room;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pkg.portal.model.hotel.Hotel;

/**
 * @author Mallareddy Belageri
 *
 */
@Entity
@Table(name = "ROOM")
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="ROOM_ID")
    private Long roomId;
	
	@Column (name="ROOM_NO")
	private String roomNo;
	
	/*@ManyToOne
    @JoinColumn(name="ROOM_CATEGORY_ID", nullable=false)
    private RoomCategory roomCategory;*/
	
	@ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "ROOM_CAT_SERVICE",
            joinColumns = { @JoinColumn(name = "ROOM_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROOM_CATEGORY_ID") })
    private Set<RoomCategory> roomCategories = new HashSet<>();
	
	@Column (name = "PRICE")
	private BigDecimal price;
	
	@ManyToOne
    @JoinColumn(name="HOTEL_ID", nullable=false)
    private Hotel hotel;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the roomId
	 */
	public Long getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomNo
	 */
	public String getRoomNo() {
		return roomNo;
	}

	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

/*	*//**
	 * @return the roomCategory
	 *//*
	@JsonManagedReference
	public RoomCategory getRoomCategory() {
		return roomCategory;
	}

	*//**
	 * @param roomCategory the roomCategory to set
	 *//*
	public void setRoomCategory(RoomCategory roomCategory) {
		this.roomCategory = roomCategory;
	}
*/
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the hotel
	 */
	@JsonBackReference
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the roomCategories
	 */
	@JsonManagedReference
	public Set<RoomCategory> getRoomCategories() {
		return roomCategories;
	}

	/**
	 * @param roomCategories the roomCategories to set
	 */
	public void setRoomCategories(Set<RoomCategory> roomCategories) {
		this.roomCategories = roomCategories;
	}
	
}
