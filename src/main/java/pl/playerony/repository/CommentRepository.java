package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.Comment;

public interface CommentRepository {
	Comment insertComment(Comment newComment) throws DatabaseException, InputException;
	
	Comment updateComment(Long id, Comment comment) throws DatabaseException, InputException;
	
	Comment findCommentById(Long id) throws DatabaseException;
	
	List<Comment> findComments() throws DatabaseException;
	
	List<Comment> findCommentsByArticleId(Long id) throws DatabaseException;
	
	void removeComment(Long id) throws DatabaseException;
}
