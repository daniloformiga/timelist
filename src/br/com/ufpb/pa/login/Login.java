package br.com.ufpb.pa.login;

import java.util.HashMap;

public class Login {
	
	public static HashMap<String, String> logins = new HashMap<String, String>();
	public static HashMap<String, String> permissions = new HashMap<String, String>();
	
	public static final String ADMIN = "A";
	public static final String SELLER = "S";

	public HashMap<String, String> getLogins() {
		return logins;
	}

	public void setLogins(HashMap<String, String> logins) {
		this.logins = logins;
	}
	
	public void addLogin(String login, String passwd){
		Login.logins.put(login, passwd);
	}
	
	public void removeLogin(String login){
		Login.logins.remove(login);
	}

	public HashMap<String, String> getPermissions() {
		return permissions;
	}

	public void setPermissions(HashMap<String, String> permissions) {
		this.permissions = permissions;
	}
	
	public void addPermission(String login, String permission){
		Login.permissions.put(login, permission);
	}
	
	public void removePermission(String login){
		Login.permissions.remove(login);
	}

}

