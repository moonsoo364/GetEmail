package com.test.mail.dao;

import java.io.IOException;

import javax.mail.MessagingException;

import com.test.mail.dto.EmailStorageDto;

public interface MailDao {

	void getEmail(EmailStorageDto emailStorageDto) throws IOException, MessagingException;
}
