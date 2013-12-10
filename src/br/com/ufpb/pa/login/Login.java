package br.com.ufpb.pa.login;

import java.util.HashMap;

public class Login {
	
	protected static HashMap<String, String> logins = new HashMap<String, String>();
	protected static HashMap<String, String> permissions = new HashMap<String, String>();
	
	public static final String ADMIN = "A";
	public static final String SELLER = "S";

	protected static HashMap<String, String> getLogins() {
		return logins;
	}

	protected static HashMap<String, String> getPermissions() {
		return permissions;
	}
	
	protected static void addLogin(String login, String passwd){
		logins.put(login, passwd);
	}
	
	protected static void removeLogin(String login){
		logins.remove(login);
	}
	
	protected static void addPermission(String login, String permission){
		permissions.put(login, permission);
	}
	
	protected static void removePermission(String login){
		permissions.remove(login);
	}

}

