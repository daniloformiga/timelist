package br.com.ufpb.pa.login;

import java.util.HashMap;

public class Login {
	
	private long id; 
	private String login;
	private String passwd;
	private String permission;
	
	public Login(long id, String login, String passwd, String permission) {
		this.setId(id);
		this.login = login;
		this.passwd = passwd;
		this.permission = permission;
	}
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
	
	

}

