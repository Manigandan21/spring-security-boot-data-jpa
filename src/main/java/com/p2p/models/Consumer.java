package com.p2p.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumer")
public class Consumer {
	
	/*"current_energy_supplier":"tneb",
    "current_supplier":"cts",
    "annual_bill":150,
    "annual_consumption":30000,
    "smart_meter_id":300*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String current_energy_supplier;
	@Column
	private String current_supplier;
	@Column
	private Long annual_bill;
	@Column
	private Long annual_consumption;
	@Column
	private Long smart_meter_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrent_energy_supplier() {
		return current_energy_supplier;
	}

	public void setCurrent_energy_supplier(String current_energy_supplier) {
		this.current_energy_supplier = current_energy_supplier;
	}

	public String getCurrent_supplier() {
		return current_supplier;
	}

	public void setCurrent_supplier(String current_supplier) {
		this.current_supplier = current_supplier;
	}

	public Long getAnnual_bill() {
		return annual_bill;
	}

	public void setAnnual_bill(Long annual_bill) {
		this.annual_bill = annual_bill;
	}

	public Long getAnnual_consumption() {
		return annual_consumption;
	}

	public void setAnnual_consumption(Long annual_consumption) {
		this.annual_consumption = annual_consumption;
	}

	public Long getSmart_meter_id() {
		return smart_meter_id;
	}

	public void setSmart_meter_id(Long smart_meter_id) {
		this.smart_meter_id = smart_meter_id;
	}

}
