package com.riachuelo.house.models;

import java.io.Serializable;

public class ItemError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String file;
	private final Long registration;
	private final String salesman;
	private final String description;
	
	
	public ItemError(ItemErrorBuilder builder) {
		this.file = builder.file;
		this.registration = builder.registration;
		this.salesman = builder.salesman;
		this.description = builder.description;
	}
	

	public Long getRegistration() {
		return registration;
	}
	public String getSalesman() {
		return salesman;
	}
	public String getFile() {
		return file;
	}
	public String getDescription() {
		return description;
	}

	
	@Override
	public String toString() {
		return "ItemError [file=" + file + ", registration=" + registration + ", salesman=" + salesman
				+ ", description=" + description + "]";
	}


	public static class ItemErrorBuilder{		
		private String file;
		private Long registration;
		private String salesman;
		private String description;
			
		public ItemErrorBuilder file(String file) {
			this.file = file;
			return this;
		}
		
		public ItemErrorBuilder registration(Long registration) {
			this.registration = registration;
			return this;
		}
		
		public ItemErrorBuilder salesman(String salesman) {
			this.salesman = salesman;
			return this;
		}
		
		public ItemErrorBuilder description(String description) {
			this.description = description;
			return this;
		}
		
		public ItemError build() {
			return new ItemError(this);
		}
	}

	
	

}
