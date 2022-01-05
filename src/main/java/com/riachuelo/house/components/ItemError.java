package com.riachuelo.house.components;

import java.io.Serializable;

public class ItemError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ItemError [id=" + id + ", description=" + description + "]";
	}
	
	

}
