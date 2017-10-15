package pl.playerony;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Article;
import pl.playerony.repository.ArticleRepository;
import pl.playerony.repository.impl.ArticleRepositoryImpl;

public class ArticleRepositoryTest {
	private ArticleRepository articleRepository;
	
	@Before
	public void initialize() {
		articleRepository = new ArticleRepositoryImpl();
	}
	
	@Test
	public void testInsertArticle() {
		Article article = new Article("Testowy", "Testowy artykuł", 1L);
		
		try {
			articleRepository.insertArticle(article);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateArticle() {
		Article article = new Article("Testowy1", "Testowy artykuł1", 1L);
		
		try {
			articleRepository.updateArticle(1L, article);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectArticle() {
		try {
			Article article = articleRepository.findArticleById(1L);
			
			System.out.println(article.toString());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectArticles() {
		try {
			List<Article> articles = articleRepository.findArticles();
			
			articles.forEach(e -> System.out.println(e.toString()));
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRemoveArticle() {
		try {
			articleRepository.removeArticle(1L);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
