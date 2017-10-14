package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.Article;

public interface ArticleRepository {
	Article insertArticle(Article newArticle) throws DatabaseException, InputException;
	
	Article updateArticle(Long id, Article article) throws DatabaseException, InputException;
	
	Article findArticleById(Long id) throws DatabaseException;
	
	List<Article> findArticles() throws DatabaseException;
	
	void removeArticle(Long id) throws DatabaseException;
}
