package com.test.mail.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mail.config.PasswordSecurity;
import com.test.mail.dao.MailDaoImpl;
import com.test.mail.dto.EmailParamDto;
import com.test.mail.dto.EmailStorageDto;
import com.test.mail.model.EmailStorage;
import com.test.mail.repository.EmailStorageRepository;

@Service
public class MailService {
	
	@Autowired
	EmailStorageRepository emailStorageRepository;
	@Autowired
	PasswordSecurity passwordSecurity;
	@Autowired
	MailDaoImpl mailDaoImpl;
	
//	public EmailStorageDto searchMailStorage(String mail) {
//		
//		System.err.println(emailStorageRepository.findByEmail(mail,EmailStorageDto.class));
//		return null;
//	}
	
	@Transactional
	public void insertmail(EmailStorage emailStorage) {
		
		emailStorageRepository.save(emailStorage);
	}
	
	public void searchMail(EmailParamDto mailParams) throws IOException,MessagingException{
		
		
	mailDaoImpl.getEmail((EmailStorageDto)emailStorageRepository.findByEmailAndProtocol(mailParams.getEmail(),mailParams.getProtocol(),EmailStorageDto.class).get(0),mailParams);
	
		
	}

}
