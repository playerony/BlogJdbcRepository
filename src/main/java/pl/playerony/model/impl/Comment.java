package pl.playerony.model.impl;

import pl.playerony.model.Converter;

public class Comment implements Converter {
	private Long id;
	private String content;
	private Long articleId;
	private Long userId;
	private Integer likes;
	private Integer dislikes;
	
	public Comment() {
		super();
	}
	
	public Comment(Object[] objectArray) {
		super();
		convert(objectArray);
	}
	
	public Comment(String content, Long articleId, Long userId, Integer likes, Integer dislikes) {
		super();
		this.content = content;
		this.articleId = articleId;
		this.userId = userId;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	
	public Comment(Long id, String content, Long articleId, Long userId, Integer likes, Integer dislikes) {
		super();
		this.id = id;
		this.content = content;
		this.articleId = articleId;
		this.userId = userId;
		this.likes = likes;
		this.dislikes = dislikes;
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

	public String getContent() {
		return content;
	}

	public Long getArticleId() {
		return articleId;
	}

	public Long getUserId() {
		return userId;
	}

	public Integer getLikes() {
		return likes;
	}

	public Integer getDislikes() {
		return dislikes;
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

	public void setContent(String content) {
		this.content = content;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
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
		return "Comment [id=" + id + ", content=" + content + 
									 ", articleId=" + articleId + 
									 ", userId=" + userId + 
									 ", likes=" + likes +
									 ", dislikes=" + dislikes + "]";
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
		this.content = objectArray[1].toString();
		this.articleId = Long.parseLong(objectArray[2].toString());
		this.userId = Long.parseLong(objectArray[3].toString());
		this.likes = Integer.parseInt(objectArray[4].toString());
		this.dislikes = Integer.parseInt(objectArray[5].toString());
	}
	
}
