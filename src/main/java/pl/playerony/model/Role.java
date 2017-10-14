package pl.playerony.model;

public class Role {
	private Long id;
	private String name;
	
	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Role() {
		super();
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
	
}