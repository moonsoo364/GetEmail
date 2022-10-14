package com.test.mail.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="email_storage", schema="emaildb")
public class EmailStorage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="email", nullable = false, updatable = true,insertable = true)
	String email;
	
	@Column(name="password", nullable = false, updatable = true,insertable = true)
	String password;
	
	@Column(name="protocol", nullable = false, updatable = true,insertable = true)
	String protocol;
	
	@Column(name="server", nullable = false, updatable = true,insertable = true)
	String server;
	
	@Column(name="port", nullable = false, updatable = true,insertable = true)
	int port;
	
	@Column(name="mail_forder", nullable = true, updatable = true,insertable = true,columnDefinition = "varchar(255) DEFAULT 'INBOX' ")
	String mailForder;
	
	@Column(name="created_date", nullable = true, updatable = false, insertable = false
			,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	Timestamp createdDate;
	
	
	
	
	
}
