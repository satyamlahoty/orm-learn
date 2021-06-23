package com.cognizant.flightmanagement.model;

import javax.persistence.Entity;

import javax.persistence.Id;


@Entity

public class Passenger {
	@Id
	private String id;
	private String name;
	private  boolean vip; 
	

	public String getName() {
		return name;
	}
	
	public  boolean isVip() {
		return vip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", vip=" + vip + "]";
	}
	
	


}
