package pl.playerony.model.validation;

import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Article;

public class ArticleValidate {
	public static void checkTitle(String title) throws InputException {
		if(title.length() < 2)
			throw new InputException("Title is too short (Min length is 2)");
		
		if(title.length() > 30)
			throw new InputException("Title is too long (Max length is 30)");
	}
	
	public static void checkContent(String content) throws InputException {
		if(content.length() < 2)
			throw new InputException("Content is too short (Min length is 2)");
	}
	
	public static void checkArticle(Article article) throws InputException {
		checkTitle(article.getTitle());
		checkContent(article.getContent());
	}
}
