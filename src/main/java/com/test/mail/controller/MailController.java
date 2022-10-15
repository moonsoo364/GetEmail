package com.test.mail.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.mail.dto.EmailParamDto;
import com.test.mail.dto.EmailStorageDto;
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
	public void searchImapMail(@RequestParam("desc")Boolean desc,@RequestParam("length")int length,@RequestParam("email")String email, @RequestParam("protocol")String protocol,@RequestParam("since")String since,@RequestParam("title")String title) throws IOException,MessagingException, ParseException{
		
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date parsedDate =dateFormat.parse(since);
		Timestamp timestamp=new Timestamp(parsedDate.getTime());
		System.err.println(email+" "+protocol+" "+desc+" "+length+ " "+timestamp+" "+title);
		mailService.searchMail(new EmailParamDto(email,protocol,desc,length,timestamp,title));

	}

}
