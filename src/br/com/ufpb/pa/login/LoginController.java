package br.com.ufpb.pa.login;


public class LoginController {
	
	Login login = new Login();
	
	public void makeLogin(){
		
		login.addLogin("admin", "admin");
		login.addPermission("admin", Login.ADMIN);
		login.addLogin("vend", "vend");
		login.addPermission("vend", Login.SELLER);
		
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
	
	public String verifyPermission(String loginText){
		
		String permission = login.getPermissions().get(loginText);
		
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

}
