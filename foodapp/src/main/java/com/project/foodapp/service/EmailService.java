package com.project.foodapp.service;

import com.project.foodapp.dto.EmailDetails;

public interface EmailService {

	// Method
	// To send a simple email
	String sendSimpleMail(EmailDetails details);

}