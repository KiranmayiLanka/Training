package com.UserBusiness.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserBusiness.Entities.BusinessProfile;
import com.UserBusiness.Entities.Profile;
import com.UserBusiness.Entities.UserProfile;
import com.UserBusiness.Service.BusinessProfileService;
import com.UserBusiness.Service.UserProfileService;

@RestController
@RequestMapping("/A4")
public class UserBusinessController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	BusinessProfileService businessProfileService;
	
	@GetMapping("/admin")
	public List<Profile> allProfiles(){
		List<Profile> allprofiles = new ArrayList<>();
		allprofiles.addAll(userProfileService.getAll());
		allprofiles.addAll(businessProfileService.getAll());
		
		return allprofiles;
		
	}
	
	@PostMapping("/addUser")
	public String saveUserProfile(@RequestBody UserProfile temp) { 
	    userProfileService.saveUserProfile(temp);
	    return "data is saved";
	}
	
	@PostMapping("/addBusinessProfile")
	public String saveBusinessProfile(@RequestBody BusinessProfile temp) {
		 businessProfileService.saveBusinessProfile(temp);
		 return "business data is saved";
	}
	
	@GetMapping("/Users")
	public List<UserProfile> userProfiles(){
		return userProfileService.getAll();
	}
	
	@GetMapping("/Business")
	public List<BusinessProfile> businessProfiles()
	{
		return businessProfileService.getAll();
	}
	
	@GetMapping("/userById/{id}")
	public UserProfile getUserProfileById(@PathVariable Long id ) {
		return userProfileService.getUserProfileById(id);
	}
	
	@GetMapping("/businessById/{id}")
	public BusinessProfile getBusinessProfileById(@PathVariable Long id) {
		return businessProfileService.getBusinessProfileById(id);
	}
	
		
	

}
