/**
 * 
 */
package com.pkg.portal.model.room;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
    @JoinColumn(name="ROOM_CATEGORY_ID", nullable=false)
    private RoomCategory roomCategory;
	
	@Column (name = "PRICE")
	private BigDecimal price;
	
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

	/**
	 * @return the roomCategory
	 */
	public RoomCategory getRoomCategory() {
		return roomCategory;
	}

	/**
	 * @param roomCategory the roomCategory to set
	 */
	public void setRoomCategory(RoomCategory roomCategory) {
		this.roomCategory = roomCategory;
	}

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
	
}
