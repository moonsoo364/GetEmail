package com.test.mail.dto;



import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;



@Data
public class EmailStorageDto {
	

	private int id;
	private String email;
	private String password;
	private String protocol;
	private String server;
	private int port;
	private String mailForder;
	private Date createdDate;
	
	public EmailStorageDto(int id, String email, String password,String protocol, String server, int port, String mailForder, Date createdDate)
	{
		this.id =id;
		this.email =email;
		this.password =password;
		this.protocol=protocol;
		this.server=server;
		this.port=port;
		this.mailForder=mailForder;
		this.createdDate=createdDate;
		
	}
	
}
