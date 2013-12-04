package br.com.ufpb.pa.login;

import java.util.HashMap;

public class LoginController {
	
	Login login = new Login();
	
	public void makeLogin(){
		
		login.addLogin("admin", "admin");
		login.addLogin("vend", "vend");
		
	}
	
	public boolean verify(String loginText, String passwd){
				
		String loginExists = login.getLogins().get(loginText);
		
		if(loginExists.equalsIgnoreCase("")){
			return false;
		}else{
			if(loginExists.equalsIgnoreCase(passwd)){
				return true;
			}else{
				return false;
			}
		}
	}

}
