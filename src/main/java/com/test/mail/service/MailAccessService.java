package com.test.mail.service;

import java.io.IOException;
import java.util.Properties;


import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.test.mail.dto.EmailStorageDto;

@Service
public class MailAccessService {
	

	
	private Store store;
	private Session session;
	private Folder folder;
	
	public boolean isLoggedIn() {
		return store.isConnected();
	}
	
	public void login(EmailStorageDto emailStorageDto) throws NoSuchProviderException,MessagingException{
		

		URLName url =new URLName(emailStorageDto.getProtocol(),emailStorageDto.getServer(),emailStorageDto.getPort(),emailStorageDto.getMailForder(),emailStorageDto.getEmail(),emailStorageDto.getPassword());
		
		System.err.println(emailStorageDto);

		Properties props = new Properties();
		session=Session.getInstance(props);

		store = session.getStore(url);
		store.connect();
		folder =store.getFolder(emailStorageDto.getMailForder());
		folder.open(Folder.READ_ONLY);
	
	}
	public void logout() throws MessagingException{
		
		folder.close(true);
		store.close();
		store=null;
		session=null;
		
	}
	public int getMessageCount() throws MessagingException{
	
	int messageCount = 0;
	messageCount = folder.getMessageCount();
	return messageCount;
	
	}
	public Message[] getMessagesByLength(int length) throws MessagingException{
		
		
			
			return folder.getMessages(1, length);
		
	}
	

	

	public Message[] getNotSeenMessages() throws MessagingException { 
		
		
		return folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
		
	}
//	public Message[] getNotSeenAndDeletedMessesges() throws MessagingException{
//		
//		return folder.getMessages();
//	
//}
//	public void checkReadMessege(int index) throws MessagingException {
//		
//		MimeMessage copy=new MimeMessage((MimeMessage) folder.getMessage(index));
//		System.err.println(copy);
//		
//	}
	public void getMessgeText(Part part) throws IOException,MessagingException{
		

		Multipart mp =(Multipart)part.getContent();
		System.err.println("multpart: "+mp);
		System.err.println("mp.count: "+mp.getCount());
		for(int i=0;i<mp.getCount();i++) {
			MimeBodyPart mimeBodyPart =(MimeBodyPart)mp.getBodyPart(i);
			System.err.println("mp.bodypart "+i+": ");
			System.err.println(mimeBodyPart.getContent().toString());
			
		}

	}
	
}
