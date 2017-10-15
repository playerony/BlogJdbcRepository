package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Comment;

public interface CommentRepository {
	Boolean insertComment(Comment newComment) throws DatabaseException, InputException;
	
	Boolean updateComment(Long id, Comment comment) throws DatabaseException, InputException;
	
	Comment findCommentById(Long id) throws DatabaseException;
	
	List<Comment> findComments() throws DatabaseException;
	
	List<Comment> findCommentsByArticleId(Long id) throws DatabaseException;
	
	Boolean removeComment(Long id) throws DatabaseException;
}
