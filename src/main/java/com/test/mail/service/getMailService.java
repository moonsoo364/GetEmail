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
import javax.mail.search.FlagTerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.test.mail.dto.EmailStorageDto;

@Service
public class getMailService {
	

	
	private Store store;
	private Session session;
	private Folder folder;
	
	public boolean isLoggedIn() {
		return store.isConnected();
	}
	
	public void login(EmailStorageDto emailStorageDto) throws NoSuchProviderException,MessagingException{
		
		String urlProtocol=emailStorageDto.getProtocol()+"s";
		String isSsl="mail."+emailStorageDto.getProtocol()+".ssl.enable";
		URLName url =new URLName(urlProtocol,emailStorageDto.getServer(),emailStorageDto.getPort(),emailStorageDto.getMailForder(),emailStorageDto.getEmail(),emailStorageDto.getPassword());
		
		System.err.println(emailStorageDto);

		Properties props = new Properties();
		props.setProperty(isSsl, "true");
		session=Session.getInstance(props);

		store = session.getStore(url);
		store.connect();
		folder =store.getFolder(emailStorageDto.getMailForder());
		folder.open(Folder.READ_ONLY);
	
	}
	public void logout() throws MessagingException{
		
		folder.close();
		store.close();
		store=null;
		session=null;
		
	}
	public int getMessageCount() throws MessagingException{
	
	int messageCount = 0;
	messageCount = folder.getMessageCount();
	return messageCount;
	
	}
	public Message[] getAllMessages() throws MessagingException{
		
			return folder.getMessages();
		
	}
	public Message[] getNotSeenMessages() throws MessagingException { 
		
		
		return folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
		
	}
	public void getMessgeText(Part part) throws IOException,MessagingException{
		

		Multipart mp =(Multipart)part.getContent();
		System.err.println("multpart: "+mp);
		System.err.println("mp.count: "+mp.getCount());
		for(int i=0;i<mp.getCount();i++) {
			MimeBodyPart mimeBodyPart =(MimeBodyPart)mp.getBodyPart(i);
			System.err.println("mp.bodypart "+i+": "+mimeBodyPart.getContent().toString());
			
		}

	}
	
}
