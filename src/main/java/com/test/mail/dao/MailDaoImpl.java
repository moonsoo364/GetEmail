package com.test.mail.dao;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.mail.dto.EmailStorageDto;
import com.test.mail.service.getMailService;

@Component
public class MailDaoImpl implements MailDao{
	
	@Autowired
	getMailService getMailService;

	@Override
	public void getEmail(EmailStorageDto emailStorageDto) throws IOException,MessagingException{
		
		

			getMailService.login(emailStorageDto);
			System.err.println("��� ���� ���� : "+getMailService.getMessageCount());
			
			Message[] notSeenmail=  getMailService.getNotSeenMessages();
			System.err.println("���� ���� ���� �� :"+notSeenmail.length);
			

			String from=null;
			String type=null;
			String title=null;
			String Content=null;

			
			//stack������� index=0�� ���� ������ ������ ������ ��
			System.err.println("���� ���� ���� ���� ��¥�� ���� �� �� 2���� ������ ��");
			for(int i=0;i<2;i++) {

				 Timestamp sentTime = new Timestamp(notSeenmail[i].getSentDate().getTime());
				 from=InternetAddress.toString(notSeenmail[i].getFrom());
				 type=notSeenmail[i].getContentType();
				 title=notSeenmail[i].getSubject();
				 System.err.println("Title: "+title);
				 System.err.println("Time: "+sentTime);
				 System.err.println("from : "+from);
				 System.err.println("type : "+type);
				 if(type.startsWith("text/")||type.startsWith("Text/")) {

					Content=notSeenmail[i].getContent().toString();
					System.err.println("Content: "+Content);
				 }else {
					 getMailService.getMessgeText(notSeenmail[i]);
				 } 
				
			}
			getMailService.logout();
			

		
		
	}

	

}
