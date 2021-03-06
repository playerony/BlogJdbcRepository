package pl.playerony.model.impl;

import pl.playerony.model.Converter;

public class Article implements Converter {
	private Long id;
	private String title;
	private String content;
	private Long userId;
	
	public Article() {
		
	}
	
	public Article(Object[] objectArray) {
		super();
		convert(objectArray);
	}
	
	public Article(String title, String content, Long userId) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
	}
	
	public Article(Long id, String title, String content, Long userId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
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

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Long getUserId() {
		return userId;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "Article [id=" + id + ", title=" + title + 
									 ", content=" + content + 
									 ", userId=" + userId +  "]";
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
		this.title = objectArray[1].toString();
		this.content = objectArray[2].toString();
		this.userId = Long.parseLong(objectArray[3].toString());
	}
	
}
