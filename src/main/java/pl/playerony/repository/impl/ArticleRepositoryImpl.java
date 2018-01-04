package pl.playerony.repository.impl;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.impl.Article;
import pl.playerony.model.validation.ArticleValidate;
import pl.playerony.repository.ArticleRepository;
import pl.playerony.util.SqlUtil;
import pl.playerony.util.converter.ConvertList;

public class ArticleRepositoryImpl implements ArticleRepository {
	private SqlManager sqlManager;
	private SqlUtil sqlUtil;
	
	public ArticleRepositoryImpl() {
		sqlManager = new SqlManager();
		sqlUtil = new SqlUtil();
	}
	
	@Override
	public Article insertArticle(Article newArticle) throws DatabaseException, InputException {
		
		ArticleValidate.checkArticle(newArticle);
		
		String sql = "INSERT INTO "
				   + "	articles(id, title, content, userId) "
				   + " VALUES(?, ?, ?, ?)";
		
		sqlManager.createQuery(sql)
								.setParameter(newArticle.getId())
								.setParameter(newArticle.getTitle())
								.setParameter(newArticle.getContent())
								.setParameter(newArticle.getUserId())
								.executeUpdate();
		
		return newArticle;
	}

	@Override
	public Boolean updateArticle(Long id, Article article) throws DatabaseException, InputException {
		ArticleValidate.checkArticle(article);
		
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
	public Article selectArticleById(Long id) throws DatabaseException {
		if(!sqlUtil.checkId("articles", id))
			throw new DatabaseException("This id[" + id + "] doesnt exist in articles table");
		
		String sql = "SELECT * "
				   + "	FROM articles "
				   + " WHERE id = ?";
		
		Article article = new Article(sqlManager.createQuery(sql)
												.setParameter(id)
												.getSingleValue());
		
		return article;
	}

	@Override
	public List<Article> selectArticles() throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM articles";
		
		List<Article> articles = ConvertList.castObjectArrayToArticleList(sqlManager.createQuery(sql)
															              		    .getExecuteList());
		
		return articles;
	}

	@Override
	public Boolean removeArticle(Long id) throws DatabaseException {
		if(!sqlUtil.checkId("articles", id))
			throw new DatabaseException("This id[" + id + "] doesnt exist in articles table");
		
		String sql = "DELETE FROM articles "
				   + "	WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
				   				   .setParameter(id)
				                   .executeQuery();

		return result > 0;
	}

}
