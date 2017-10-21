package pl.playerony.repository;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.model.impl.Comment;

public interface CommentRepository {
	Comment insertComment(Comment newComment) throws DatabaseException, InputException;
	
	Boolean updateComment(Long id, Comment comment) throws DatabaseException, InputException;
	
	Comment selectCommentById(Long id) throws DatabaseException;
	
	List<Comment> selectComments() throws DatabaseException;
	
	List<Comment> selectCommentsByArticleId(Long articleId) throws DatabaseException;
	
	Boolean removeComment(Long id) throws DatabaseException;
}
