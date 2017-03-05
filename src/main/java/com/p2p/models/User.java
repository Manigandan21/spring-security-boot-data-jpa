/**
 * 
 */
package com.p2p.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Manigandan
 */
@Entity
@Table(name = "user_basic_info")
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long user_id;
	@Column(name="username")
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
	
	
	@OneToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	@JoinColumn(name = "CONSUMER_ID" , referencedColumnName="id")
	Consumer consumer;
	 
	 @OneToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	 @JoinColumn(name = "PROSUMER_ID" ,referencedColumnName="id")
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
