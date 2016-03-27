package com.cbms.model.entity;

// Generated Jan 13, 2016 10:40:11 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserType generated by hbm2java
 */
@Entity
@Table(name = "user_type", schema = "public")
public class UserType implements java.io.Serializable {

	private short id;
	private String userType;
	private Short statCode;

	public UserType() {
	}

	public UserType(short id, String userType) {
		this.id = id;
		this.userType = userType;
	}

	public UserType(short id, String userType, Short statCode) {
		this.id = id;
		this.userType = userType;
		this.statCode = statCode;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	@Column(name = "user_type", nullable = false, length = 20)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "stat_code")
	public Short getStatCode() {
		return this.statCode;
	}

	public void setStatCode(Short statCode) {
		this.statCode = statCode;
	}

}
