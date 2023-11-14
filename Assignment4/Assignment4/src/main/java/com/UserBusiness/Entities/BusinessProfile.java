package com.UserBusiness.Entities;

import jakarta.persistence.Entity;

@Entity
public class BusinessProfile extends Profile {
	
	    private String companyName;

		public BusinessProfile(String firstName, String lastName, String type, String companyName) {
			super(firstName, lastName, type);
			this.companyName = companyName;
			// TODO Auto-generated constructor stub
		}
		
		public BusinessProfile() {
			
		}

		public BusinessProfile(String companyName) {
			super();
			this.companyName = companyName;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
	    
		
	    
	    
	    
	    
}
