package br.com.ufpb.pa.login;

import java.util.HashMap;

public class Login {
	
	HashMap<String, String> logins = new HashMap<String, String>();

	public HashMap<String, String> getLogins() {
		return logins;
	}

	public void setLogins(HashMap<String, String> logins) {
		this.logins = logins;
	}
	
	public void addLogin(String login, String passwd){
		logins.put(login, passwd);
	}
	
	public void removeLogin(String login){
		logins.remove(login);
	}

}

