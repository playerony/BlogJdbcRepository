package pl.playerony.model;

public class Comment {
	private Long id;
	private String content;
	private Long articleId;
	private Long userId;
	private Integer likes;
	private Integer dislikes;
	
	public Comment(Long id, String content, Long articleId, Long userId, Integer likes, Integer dislikes) {
		super();
		this.id = id;
		this.content = content;
		this.articleId = articleId;
		this.userId = userId;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	
	public Comment(String content, Long articleId, Long userId, Integer likes, Integer dislikes) {
		super();
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
	
}
