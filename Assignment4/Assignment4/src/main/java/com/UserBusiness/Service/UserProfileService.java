package com.UserBusiness.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserBusiness.Entities.UserProfile;
import com.UserBusiness.ExceptionHandlers.ProfileNotFound;
import com.UserBusiness.Repositories.UserProfileRepository;


@Service
public class UserProfileService {
	
	@Autowired
	UserProfileRepository userProfileRepo;
	private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);
	
	public UserProfile saveUserProfile(UserProfile userProfile) {
		
		UserProfile user = new UserProfile();
		user.setFirstName(userProfile.getFirstName());
		user.setLastName(userProfile.getLastName());
		user.setType(userProfile.getType());
		user.setUsername(userProfile.getUsername());
		
		return userProfileRepo.save(user);	
	}
	
	public List<UserProfile> getAll(){
		
		logger.info("This is an info log from UserProfileService.");
		return userProfileRepo.findAll();	
	}
	

	public UserProfile getUserProfileById(Long Id) {
		
		if (!(userProfileRepo.existsById(Id))) {
			
			throw new ProfileNotFound("required profile is not found");
			
		}
		   
		 return userProfileRepo.findById(Id).get();
		   
	   }
	
	
	
	

}
