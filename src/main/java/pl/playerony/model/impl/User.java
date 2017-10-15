package pl.playerony.model.impl;

import pl.playerony.model.Converter;

public class User implements Converter {
	private Long id;
	private String login;
	private String password;
	private Long roleId;
	
	public User(Long id, String login, String password, Long roleId) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.roleId = roleId;
	}
	
	public User(String login, String password, Long roleId) {
		super();
		this.login = login;
		this.password = password;
		this.roleId = roleId;
	}
	
	public User(Object[] objectArray) {
		super();
		convert(objectArray);
	}
	
	/**
	 * 
	 * Getters
	 * 
	 * @return
	 * 
	 */

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Long getRoleId() {
		return roleId;
	}
	
	/**
	 * 
	 * Setters
	 * 
	 * @return
	 * 
	 */

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * 
	 * toString
	 * 
	 * @return
	 * 
	 */
	
	@Override
	public String toString()
	{
		return "User [id=" + id + ", login=" + login + 
								  ", password=" + password + 
								  ", roleId=" + roleId + "]";
	}

	/**
	 * 
	 * converter
	 * 
	 * @return
	 * 
	 */

	@Override
	public void convert(Object[] objectArray) {
		this.id = Long.parseLong(objectArray[0].toString());
		this.login = objectArray[1].toString();
		this.password = objectArray[2].toString();
		this.roleId = Long.parseLong(objectArray[3].toString());
	}
	
}
