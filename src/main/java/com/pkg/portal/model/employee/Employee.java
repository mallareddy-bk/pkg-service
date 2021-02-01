/**
 * 
 */
package com.pkg.portal.model.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

/**
 * @author Mallareddy Belageri
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="ID")
    private Long id;
	
	@Column (name="EMP_ID")
	private String empId;
	
	@Column (name="PASSWORD")
	//@ColumnTransformer(read = "pgp_sym_decrypt(password, 'mySecretKey')", write = "pgp_sym_encrypt(?, 'mySecretKey')")
	private String password;
	
	@Column (name="NAME")
	private String name;
	
	@Column (name="DESIGNATION")
	private String designation;
	
	@Column (name="EMAIL_ID")
	private String emailId;
	
	@Column (name="ADDRESS")
	private String address;
	
	@Column (name="IDENTITY_NO")
	private String identityNo;
	
	@Column (name="GENDER")
	private String gender;
	
	@Column (name="PHONE_NO")
	private String phoneNumber;
	
	@Column (name="CR_DATE")
	private Date createdDate;
	
	@Column (name="MF_DATE")
	private Date modifiedDate;

	public Employee() {
		
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the identityNo
	 */
	public String getIdentityNo() {
		return identityNo;
	}

	/**
	 * @param identityNo the identityNo to set
	 */
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
