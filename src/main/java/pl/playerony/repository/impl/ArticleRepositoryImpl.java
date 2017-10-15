package pl.playerony.repository.impl;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.impl.Article;
import pl.playerony.repository.ArticleRepository;
import pl.playerony.util.converter.ConvertList;

public class ArticleRepositoryImpl implements ArticleRepository {
private SqlManager sqlManager;
	
	public ArticleRepositoryImpl() {
		sqlManager = new SqlManager();
	}
	
	@Override
	public Boolean insertArticle(Article newArticle) throws DatabaseException, InputException {
		String sql = "INSERT INTO "
				   + "	articles(id, title, content, userId) "
				   + " VALUES(?, ?, ?, ?)";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(newArticle.getId())
								   .setParameter(newArticle.getTitle())
								   .setParameter(newArticle.getContent())
								   .setParameter(newArticle.getUserId())
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public Boolean updateArticle(Long id, Article article) throws DatabaseException, InputException {
		String sql = "UPDATE articles "
				   + "	SET title = ?, "
				   + "		content = ? "
				   + "		userId = ? "
				   + " WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(article.getTitle())
								   .setParameter(article.getContent())
								   .setParameter(article.getUserId())
								   .setParameter(id)
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public Article findArticleById(Long id) throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM articles "
				   + " WHERE id = ?";
		
		Article article = new Article(sqlManager.createQuery(sql)
												.setParameter(id)
												.getSingleValue());
		
		return article;
	}

	@Override
	public List<Article> findArticles() throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM articles";
		
		List<Article> articles = ConvertList.castListOfObjectsToArticles(sqlManager.createQuery(sql)
															              		   .getExecuteList());
		
		return articles;
	}

	@Override
	public Boolean removeArticle(Long id) throws DatabaseException {
		String sql = "DELETE FROM articles "
				   + "	WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
				   				   .setParameter(id)
				                   .executeQuery();

		return result > 0;
	}

}
