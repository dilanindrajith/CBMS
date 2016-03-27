package com.cbms.model.entity;

// Generated Nov 6, 2015 5:51:12 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoginUser generated by hbm2java
 */
@Entity
@Table(name = "login_user", schema = "public")
public class LoginUser implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
	private short id;
	private String userName;
	private short userTypeId;
	private short sysUserId;
	private String branchCode;
	private Short statCode;

	public LoginUser() {
	}

	public LoginUser(short id, short userTypeId, short sysUserId) {
		this.id = id;
		this.userTypeId = userTypeId;
		this.sysUserId = sysUserId;
	}

	public LoginUser(short id, String userName, short userTypeId,
			short sysUserId, String branchCode, Short statCode) {
		this.id = id;
		this.userName = userName;
		this.userTypeId = userTypeId;
		this.sysUserId = sysUserId;
		this.branchCode = branchCode;
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

	@Column(name = "user_name", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_type_id", nullable = false)
	public short getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(short userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Column(name = "sys_user_id", nullable = false)
	public short getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(short sysUserId) {
		this.sysUserId = sysUserId;
	}

	@Column(name = "branch_code", length = 10)
	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name = "stat_code")
	public Short getStatCode() {
		return this.statCode;
	}

	public void setStatCode(Short statCode) {
		this.statCode = statCode;
	}

}