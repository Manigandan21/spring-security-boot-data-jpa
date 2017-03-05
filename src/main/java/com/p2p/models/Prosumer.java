package com.p2p.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prosumer")
public class Prosumer {
	
	/*"project_name": "Wind Mil",
    "postcode": 603310,
    "tech_type": "Solar",
    "installed_capacity_kw": 34.2,
    "current_supplier": "cts",
    "smart_meter_id": 23*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String project_name;
	@Column
	private String current_supplier;
	@Column
	private Long postcode;
	@Column
	private Float installed_capacity_kw;
	@Column
	private Long smart_meter_id;
	@Column
	private String tech_type;
	
	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getCurrent_supplier() {
		return current_supplier;
	}

	public void setCurrent_supplier(String current_supplier) {
		this.current_supplier = current_supplier;
	}

	public Long getPostcode() {
		return postcode;
	}

	public void setPostcode(Long postcode) {
		this.postcode = postcode;
	}

	public Float getInstalled_capacity_kw() {
		return installed_capacity_kw;
	}

	public void setInstalled_capacity_kw(Float installed_capacity_kw) {
		this.installed_capacity_kw = installed_capacity_kw;
	}

	public Long getSmart_meter_id() {
		return smart_meter_id;
	}

	public void setSmart_meter_id(Long smart_meter_id) {
		this.smart_meter_id = smart_meter_id;
	}

	public String getTech_type() {
		return tech_type;
	}

	public void setTech_type(String tech_type) {
		this.tech_type = tech_type;
	}

	public Long geId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
