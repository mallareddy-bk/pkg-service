/**
 * 
 */
package com.pkg.portal.model.room;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Mallareddy Belageri
 *
 */
@Entity
@Table(name = "ROOM_CATEGORY")
public class RoomCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="ROOM_CATEGORY_ID")
    private Long roomCatId;
	
	@Column (name="ROOM_CATEGORY_CODE")
	private String roomCatCode;
	
	@Column (name="ROOM_CATEGORY_Name")
	private String roomCatName;
	
	/*@OneToMany(mappedBy="roomCategory")
    private Set<Room> rooms;*/
	
	@ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "roomCategories")
    private Set<Room> rooms = new HashSet<>();
	
	public RoomCategory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the roomCatId
	 */
	public Long getRoomCatId() {
		return roomCatId;
	}

	/**
	 * @param roomCatId the roomCatId to set
	 */
	public void setRoomCatId(Long roomCatId) {
		this.roomCatId = roomCatId;
	}

	/**
	 * @return the roomCatCode
	 */
	public String getRoomCatCode() {
		return roomCatCode;
	}

	/**
	 * @param roomCatCode the roomCatCode to set
	 */
	public void setRoomCatCode(String roomCatCode) {
		this.roomCatCode = roomCatCode;
	}

	/**
	 * @return the roomCatName
	 */
	public String getRoomCatName() {
		return roomCatName;
	}

	/**
	 * @param roomCatName the roomCatName to set
	 */
	public void setRoomCatName(String roomCatName) {
		this.roomCatName = roomCatName;
	}

	/**
	 * @return the rooms
	 */
	@JsonBackReference
	public Set<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}


}
