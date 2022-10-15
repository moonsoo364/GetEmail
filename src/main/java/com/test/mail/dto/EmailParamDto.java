package com.test.mail.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailParamDto {

	private String email;
	private String protocol;
	private boolean desc;
	private int length;
	private Timestamp since;
	private String title;
	
	
}
