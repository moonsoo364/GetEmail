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
			System.err.println("읽지 않은 메일 수 :"+notSeenmail.length);
			//pop3는 어느 폴더에서 메일이 먼저 있는 지 모른다,
			//정렬 기능을 사용하려면 imap을 사용 권장
			
			//제목에 특정 문자열이 들어가 있는 지 확인
			if(mailParams.getLength()>1) {
				//날짜 내림차순 정렬
				if(mailParams.isDesc()) {
					for(int index=1;index<mailParams.getLength()+1;index++) {
						
						int number =notSeenmail.length-index;
						Timestamp sentDate=new Timestamp(notSeenmail[number].getSentDate().getTime());

					}
				//날짜 오름차순 정렬
				}else {
					for(int index=0;index<mailParams.getLength();index++) {
						
						Timestamp sentDate=new Timestamp(notSeenmail[index].getSentDate().getTime());

					}
				}
			}
//			특정 날짜 이전/이후 메일 확인
//			if(mailParams.getLength()>1) {
//				//날짜 내림차순 정렬
//				if(mailParams.isDesc()) {
//					for(int index=1;index<mailParams.getLength()+1;index++) {
//						
//						int number =notSeenmail.length-index;
//						Timestamp sentDate=new Timestamp(notSeenmail[number].getSentDate().getTime());
//						
//						//특정 날짜 이전에 있는 지 확인
//						if(sentDate.before(mailParams.getSince())) {
//							
//							System.err.println("메일 제목: "+notSeenmail[number].getSubject());
//						}else if(index==mailParams.getLength()){
//							System.err.println("최근 메일"+mailParams.getLength()+"개 중"+mailParams.getSince()+"이전 메일이 없습니다.");
//						}
//						
//						
//					}
//				//날짜 오름차순 정렬
//				}else {
//					for(int index=0;index<mailParams.getLength();index++) {
//						
//						Timestamp sentDate=new Timestamp(notSeenmail[index].getSentDate().getTime());
//						//특정 날짜 이후로 메일이 있는 지 확인
//						if(sentDate.after(mailParams.getSince())) {
//							System.err.println("메일 제목 : "+notSeenmail[index].getSubject());
//						}else if(index==mailParams.getLength()-1) {
//							System.err.println("마지막 메일"+mailParams.getLength()+"개 중"+mailParams.getSince()+"이후 메일이 없습니다.");
//						}
//					}
//				}
//			}
			
// text, html content 확인용	
//			for(int i=0;i<mailParams.getLength();i++) {
//				System.err.println("date: "+new Timestamp(notSeenmail[i].getSentDate().getTime()) );
//			}
			
//			Message[] notSeenmail=  mailAccessService.getNotSeenMessages();
//			System.err.println("읽지 않은 메일 수 :"+notSeenmail.length);
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
