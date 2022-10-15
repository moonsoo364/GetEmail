package com.test.mail.dao;

import java.io.IOException;
import java.sql.Timestamp;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.mail.dto.EmailParamDto;
import com.test.mail.dto.EmailStorageDto;
import com.test.mail.service.MailAccessService;

@Component
public class MailDaoImpl implements MailDao{
	
	@Autowired
	MailAccessService mailAccessService;

	@Override
	public void getEmail(EmailStorageDto emailStorageDto,EmailParamDto mailParams) throws IOException,MessagingException{
		
		

			mailAccessService.login(emailStorageDto);
			
			
			Message[] notSeenmail=  mailAccessService.getNotSeenMessages();
			System.err.println("���� ���� ���� �� :"+notSeenmail.length);
			//pop3�� ��� �������� ������ ���� �ִ� �� �𸥴�,
			//���� ����� ����Ϸ��� imap�� ��� ����
			
			//���� Ư�� ���ڿ��� �� �ִ� �� Ȯ��
			if(mailParams.getLength()>1) {
				//��¥ �������� ����
				if(mailParams.isDesc()) {
					for(int index=1;index<mailParams.getLength()+1;index++) {
						
						int number =notSeenmail.length-index;
						Timestamp sentDate=new Timestamp(notSeenmail[number].getSentDate().getTime());

					}
				//��¥ �������� ����
				}else {
					for(int index=0;index<mailParams.getLength();index++) {
						
						Timestamp sentDate=new Timestamp(notSeenmail[index].getSentDate().getTime());

					}
				}
			}
//			Ư�� ��¥ ����/���� ���� Ȯ��
//			if(mailParams.getLength()>1) {
//				//��¥ �������� ����
//				if(mailParams.isDesc()) {
//					for(int index=1;index<mailParams.getLength()+1;index++) {
//						
//						int number =notSeenmail.length-index;
//						Timestamp sentDate=new Timestamp(notSeenmail[number].getSentDate().getTime());
//						
//						//Ư�� ��¥ ������ �ִ� �� Ȯ��
//						if(sentDate.before(mailParams.getSince())) {
//							
//							System.err.println("���� ����: "+notSeenmail[number].getSubject());
//						}else if(index==mailParams.getLength()){
//							System.err.println("�ֱ� ����"+mailParams.getLength()+"�� ��"+mailParams.getSince()+"���� ������ �����ϴ�.");
//						}
//						
//						
//					}
//				//��¥ �������� ����
//				}else {
//					for(int index=0;index<mailParams.getLength();index++) {
//						
//						Timestamp sentDate=new Timestamp(notSeenmail[index].getSentDate().getTime());
//						//Ư�� ��¥ ���ķ� ������ �ִ� �� Ȯ��
//						if(sentDate.after(mailParams.getSince())) {
//							System.err.println("���� ���� : "+notSeenmail[index].getSubject());
//						}else if(index==mailParams.getLength()-1) {
//							System.err.println("������ ����"+mailParams.getLength()+"�� ��"+mailParams.getSince()+"���� ������ �����ϴ�.");
//						}
//					}
//				}
//			}
			
// text, html content Ȯ�ο�	
//			for(int i=0;i<mailParams.getLength();i++) {
//				System.err.println("date: "+new Timestamp(notSeenmail[i].getSentDate().getTime()) );
//			}
			
//			Message[] notSeenmail=  mailAccessService.getNotSeenMessages();
//			System.err.println("���� ���� ���� �� :"+notSeenmail.length);
//			String from=null;
//			String type=null;
//			String title=null;
//			String Content=null;
//			for(int i=0;i<2;i++) {
//
//				 Timestamp sentTime = new Timestamp(notSeenmail[i].getSentDate().getTime());
//				 from=InternetAddress.toString(notSeenmail[i].getFrom());
//				 type=notSeenmail[i].getContentType();
//				 title=notSeenmail[i].getSubject();
//				 System.err.println("Title: "+title);
//				 System.err.println("Time: "+sentTime);
//				 System.err.println("from : "+from);
//				 System.err.println("type : "+type);
//				 if(type.startsWith("text/")||type.startsWith("Text/")) {
//
//					Content=notSeenmail[i].getContent().toString();
//					System.err.println("Content: "+Content);
//				 }else {
//					 getMailService.getMessgeText(notSeenmail[i]);
//				 }
// 
			


			mailAccessService.logout();
			

		
		
	}

	

}
