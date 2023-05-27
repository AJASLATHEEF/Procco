package org.dcryptutils;

import java.util.Base64;

import org.common.BaseClass;

public class DcryptUtils extends BaseClass {

	public  String token;
	public  String username;
	public  String password;

	public void Dcrypt_username() {

		String Username = prop.getProperty("username");
		byte[] decrypt = Base64.getDecoder().decode(Username);		
		username = new String(decrypt);

	}
	
	public void Dcrypt_password() {

		String Password = prop.getProperty("password");
		byte[] decrypt = Base64.getDecoder().decode(Password);		
		password = new String(decrypt);

	}
	
	public void Dcrypt_token() {
		String password = prop.getProperty("token");	
		byte[] decrypt = Base64.getDecoder().decode(password);		
		token = new String(decrypt);			
	}


}


