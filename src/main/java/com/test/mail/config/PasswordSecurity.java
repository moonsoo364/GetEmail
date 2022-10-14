package com.test.mail.config;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.stereotype.Component;

@Component
public class PasswordSecurity {
	public SecretKey generateKey() throws NoSuchAlgorithmException{
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(256);
		SecretKey key = keyGenerator.generateKey();
		
		return key;
		
	}
	public IvParameterSpec generateIv() {
		//16자리 난수발생기 Initialization vector
		byte[] iv =new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}
	public static String encrypt(String input ,SecretKey key, IvParameterSpec iv) 
			
	{
	return null;	
		
	}
	public static String decrypt(String cipherText, SecretKey key,IvParameterSpec iv)
			
	{
	return null;
	}


}
