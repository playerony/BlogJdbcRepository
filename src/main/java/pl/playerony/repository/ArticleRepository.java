package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Article;

public interface ArticleRepository {
	Boolean insertArticle(Article newArticle) throws DatabaseException, InputException;
	
	Boolean updateArticle(Long id, Article article) throws DatabaseException, InputException;
	
	Article selectArticleById(Long id) throws DatabaseException;
	
	List<Article> selectArticles() throws DatabaseException;
	
	Boolean removeArticle(Long id) throws DatabaseException;
}
