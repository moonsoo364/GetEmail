package com.test.mail.dao;

import java.io.IOException;

import javax.mail.MessagingException;

import com.test.mail.dto.EmailParamDto;
import com.test.mail.dto.EmailStorageDto;

public interface MailDao {

	void getEmail(EmailStorageDto emailStorageDto,EmailParamDto mailParams) throws IOException, MessagingException;
}
