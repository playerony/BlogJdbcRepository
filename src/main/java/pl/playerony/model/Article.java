package pl.playerony.model;

public class Article {
	private Long id;
	private String title;
	private String content;
	private Long userId;
	
	public Article(Long id, String title, String content, Long userId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public Article(String title, String content, Long userId) {
		super();
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
	
}
