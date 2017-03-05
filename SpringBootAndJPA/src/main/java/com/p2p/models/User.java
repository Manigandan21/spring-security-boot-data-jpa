/**
 * 
 */
package com.p2p.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Manigandan
 */
@Entity
@Table(name = "USER_BASIC_INFO")
public class User implements Serializable{

	
	/*"user_id":6,
    "username": "Mani",
    "email": "mo@gmail.com",
    "phone": "9944288328",
    "password": "21.Dece",
    "confirm_password": "21.Dece",
    "roleType": 1,*/
	
	private static final long serialVersionUID = 1L;
	@Id
	Long user_id;
	@Column
	String userName;
	@Column
	String email;
	@Column
	String phone;
	@Column
	String password;
	@Column
	String confirm_password;
	@Column
	Integer role_type;
	
	Consumer consumer;
	
	Prosumer prosumer;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public Integer getRole_type() {
		return role_type;
	}

	public void setRole_type(Integer role_type) {
		this.role_type = role_type;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Prosumer getProsumer() {
		return prosumer;
	}

	public void setProsumer(Prosumer prosumer) {
		this.prosumer = prosumer;
	}
	
}
