package pl.playerony;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Comment;
import pl.playerony.repository.CommentRepository;
import pl.playerony.repository.impl.CommentRepositoryImpl;

public class CommentRepositoryTest {
	private CommentRepository commentRepository;
	
	@Before
	public void initialize() {
		commentRepository = new CommentRepositoryImpl();
	}
	
	@Test
	public void testInsertComment() {
		Comment comment = new Comment("Jebany test", 1L, 1L, 6, 9);
		
		try {
			commentRepository.insertComment(comment);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateComment() {
		Comment comment = new Comment("Jebany test", 1L, 1L, 9, 6);
		
		try {
			commentRepository.updateComment(1L, comment);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectCommentById() {
		try {
			Comment comment = commentRepository.findCommentById(1L);
			
			System.out.println(comment.toString());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectCommentsByArticleId() {
		try {
			List<Comment> comments = commentRepository.findCommentsByArticleId(1L);
			
			comments.forEach(e -> System.out.println(e.toString()));
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectComments() {
		try {
			List<Comment> comments = commentRepository.findComments();
			
			comments.forEach(e -> System.out.println(e.toString()));
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRemoveComment() {
		try {
			commentRepository.removeComment(1L);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
