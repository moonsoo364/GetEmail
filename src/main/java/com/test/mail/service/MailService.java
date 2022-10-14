package com.test.mail.service;

import java.io.IOException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.mail.config.PasswordSecurity;
import com.test.mail.dao.MailDaoImpl;
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
	
	public void searchMail(String email,String protocol) throws IOException,MessagingException{
		
		
	mailDaoImpl.getEmail((EmailStorageDto)emailStorageRepository.findByEmailAndProtocol(email,protocol,EmailStorageDto.class).get(0));
	
		
	}

}
