package br.com.ufpb.pa.login;

import java.util.HashMap;


public class LoginController {
	
	public LoginController(){
		
		Login.addLogin("admin", "admin");
		Login.addPermission("admin", Login.ADMIN);
		Login.addLogin("vend", "vend");
		Login.addPermission("vend", Login.SELLER);
		
	}
	
	public boolean verify(String loginText, String passwd){
				
		if(loginText == null || loginText.equalsIgnoreCase("")){
			return false;
		}else{
			
			String loginExists = Login.logins.get(loginText);
			
			if(loginExists != null){
						
				if(loginExists.equalsIgnoreCase(passwd)){
					return true;
				}else{
					return false;
				}
				
			}else{
				return false;
			}
			
		}
		
	}
	
	public String verifyPermission(String loginText){
		
		String permission = Login.getPermissions().get(loginText);
		
		if(permission.equalsIgnoreCase("")){
			return null;
		}else{
			if(permission.equalsIgnoreCase(Login.ADMIN)){
				return Login.ADMIN;
			}else{
				return Login.SELLER;
			}
		}
	}
	
	public void addLogin(String loginText, String passwdText, String permissionText){
		Login.addLogin(loginText, passwdText);
		Login.addPermission(loginText, permissionText);
	}
	
	public void removeLogin(String loginText){
		Login.removeLogin(loginText);
		Login.removePermission(loginText);
	}
	
	public int getSizeLogin(){
		return Login.getLogins().size();
	}
	
	public int getSizePermissions(){
		return Login.getPermissions().size();
	}
	
	public HashMap<String, String> getLogins(){
		return Login.logins;
	}
	
	public HashMap<String, String> getPermissions(){
		return Login.permissions;
	}
	
}
