package br.com.ufpb.pa.login;

public class LoginController {
	
	Login login = new Login();
	
	public void makeLogin(){
		
		login.addLogin("admin", "admin");
		login.addLogin("vend", "vend");
		
	}
	
	public boolean verify(String loginText, String passwd){
		if(login.verifyCredencials(loginText, passwd)){
			return true;
		}
		return false;
	}

}
