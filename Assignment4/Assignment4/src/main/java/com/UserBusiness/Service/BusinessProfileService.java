package com.UserBusiness.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UserBusiness.Entities.BusinessProfile;
import com.UserBusiness.ExceptionHandlers.ProfileNotFound;
import com.UserBusiness.Repositories.BusinessProfileRepository;

@Service
public class BusinessProfileService {
	
	@Autowired
	BusinessProfileRepository businessProfileRepo;
	private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);
	
	
	public BusinessProfile saveBusinessProfile (BusinessProfile businessProfile) {
		
		BusinessProfile businessUser = new BusinessProfile();
		businessUser.setFirstName(businessProfile.getFirstName());
		businessUser.setLastName(businessProfile.getLastName());
		businessUser.setType(businessProfile.getType());
		businessUser.setCompanyName(businessProfile.getCompanyName());
		
		return businessProfileRepo.save(businessUser);
			
	}
	
   public List<BusinessProfile> getAll(){
	   
	   logger.info("This is an info log from BusinessProfileService.");
		return businessProfileRepo.findAll();	
	}
   
   public BusinessProfile getBusinessProfileById(Long Id) {
	   
	   if (!(businessProfileRepo.existsById(Id))){
		   
		   throw new ProfileNotFound("Required business profile is not found");
		
	}
	   return businessProfileRepo.findById(Id).get();
	   
   }
	

}
