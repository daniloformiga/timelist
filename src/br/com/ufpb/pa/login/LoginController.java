package br.com.ufpb.pa.login;


public class LoginController {
	
	Login login = new Login();
	
	public LoginController(){
		
		login.addLogin("admin", "admin");
		login.addPermission("admin", Login.ADMIN);
		login.addLogin("vend", "vend");
		login.addPermission("vend", Login.SELLER);
		
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
