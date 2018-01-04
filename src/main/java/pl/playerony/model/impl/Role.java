package pl.playerony.model.impl;

import pl.playerony.model.Converter;

public class Role implements Converter {
	private Long id;
	private String name;
	
	public Role() {
		super();
	}
	
	public Role(Object[] objectArray) {
		super();
		convert(objectArray);
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}
	
	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
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
		return "Role [id=" + id + ", name=" + name + "]";
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
		this.name = objectArray[1].toString();
	}
	
}
