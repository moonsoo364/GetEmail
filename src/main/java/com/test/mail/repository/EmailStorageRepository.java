package com.test.mail.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.mail.dto.EmailStorageDto;
import com.test.mail.model.EmailStorage;


public interface EmailStorageRepository extends JpaRepository<EmailStorage, Integer>{
	
	
	 List<?> findByEmailAndProtocol(String email,String protocol,Class<?> type);
}
