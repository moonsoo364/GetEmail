package com.test.mail.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.mail.model.EmailStorage;
import com.test.mail.service.MailService;

@RestController
@RequestMapping("/api")
public class MailController {
	
	@Autowired
	MailService mailService;
	
//	@GetMapping("/mail")
//	public void searchmail(@RequestParam("email")String email) {
//		
//		mailService.searchMailStorage(email);
//	}
	@PostMapping("/mail")
	public void insertmail(@RequestBody EmailStorage emailStorage) {
		System.err.println(emailStorage);
		mailService.insertmail(emailStorage);
	}
	@GetMapping("/mail")
	public void searchImapMail(@RequestParam("email")String email, @RequestParam("protocol")String protocol) throws IOException,MessagingException{
		System.err.println(email+" "+protocol);

		mailService.searchMail(email,protocol);

	}

}
