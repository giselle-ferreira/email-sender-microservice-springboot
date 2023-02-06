package com.micro.email.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.email.dtos.EmailDto;
import com.micro.email.models.EmailModel;
import com.micro.email.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
		EmailModel emailModel = new EmailModel();
		
		//converts from Dto to Model
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);
		
		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
	}
	
}
