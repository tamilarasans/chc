package com.chc.offerapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Offer {
	private String name;
	private String desc;
	private int maxVal=0;
	private int minVal=0;
	private int offPtMax=0;
	private int offPtMin=0;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getMaxVal() {
		return maxVal;
	}
	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}
	public int getMinVal() {
		return minVal;
	}
	public void setMinVal(int minVal) {
		this.minVal = minVal;
	}
	public int getOffPtMax() {
		return offPtMax;
	}
	public void setOffPtMax(int offPtMax) {
		this.offPtMax = offPtMax;
	}
	public int getOffPtMin() {
		return offPtMin;
	}
	public void setOffPtMin(int offPtMin) {
		this.offPtMin = offPtMin;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
