package com.wwy.sample.springdata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/***
 * 鐢ㄦ埛
 * 
 * @author 鏂囧哀
 *
 */
@Entity
@Table(name = "USER2")
public class User extends IdEntity {

	public enum Sex {

		male, female, unknow,;

		public String getInfo() {
			switch (this) {
			case male:
				return "男性";
			case female:
				return "女性";
			default:
				return "未知";
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -462409132015864586L;
	private String username;
	private String mobileno;
	private String password;
	private String salt;
	private Sex sex;

	private Date addDate;

	private Date modifyDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
