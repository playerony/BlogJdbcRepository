package pl.playerony.repository.impl;

import java.util.List;

import pl.playerony.exception.DatabaseException;
import pl.playerony.exception.InputException;
import pl.playerony.manager.SqlManager;
import pl.playerony.model.impl.Comment;
import pl.playerony.repository.CommentRepository;
import pl.playerony.util.converter.ConvertList;

public class CommentRepositoryImpl implements CommentRepository {
	private SqlManager sqlManager;
	
	public CommentRepositoryImpl() {
		sqlManager = new SqlManager();
	}
	
	@Override
	public Boolean insertComment(Comment newComment) throws DatabaseException, InputException {
		String sql = "INSERT INTO "
				   + "	comments(id, content, articleId, userId, likes, dislikes) "
				   + " VALUES(?, ?, ?, ?, ?, ?)";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(newComment.getId())
								   .setParameter(newComment.getContent())
								   .setParameter(newComment.getArticleId())
								   .setParameter(newComment.getUserId())
								   .setParameter(newComment.getLikes())
								   .setParameter(newComment.getDislikes())
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public Boolean updateComment(Long id, Comment comment) throws DatabaseException, InputException {
		String sql = "UPDATE comments "
				   + "	SET content = ?, "
				   + "		articleId = ? "
				   + "		userId = ? "
				   + "		likes = ? "
				   + "		dislikes = ? "
				   + " WHERE ID = ?";
		
		Integer result = sqlManager.createQuery(sql)
								   .setParameter(comment.getContent())
								   .setParameter(comment.getArticleId())
								   .setParameter(comment.getUserId())
								   .setParameter(comment.getLikes())
								   .setParameter(comment.getDislikes())
								   .setParameter(id)
								   .executeQuery();
		
		return result > 0;
	}

	@Override
	public Comment findCommentById(Long id) throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM comments "
				   + " WHERE id = ?";
		
		Comment comment = new Comment(sqlManager.createQuery(sql)
												.setParameter(id)
												.getSingleValue());
		
		return comment;
	}

	@Override
	public List<Comment> findComments() throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM comments";
		
		List<Comment> comments = ConvertList.castListOfObjectsToComments(sqlManager.createQuery(sql)
															              		   .getExecuteList());
		
		return comments;
	}

	@Override
	public List<Comment> findCommentsByArticleId(Long articleId) throws DatabaseException {
		String sql = "SELECT * "
				   + "	FROM comments "
				   + " WHERE articleId = ?";
		
		List<Comment> comments = ConvertList.castListOfObjectsToComments(sqlManager.createQuery(sql)
																				   .setParameter(articleId)
															              		   .getExecuteList());
		
		return comments;
	}

	@Override
	public Boolean removeComment(Long id) throws DatabaseException {
		String sql = "DELETE FROM comments "
				   + "	WHERE id = ?";
		
		Integer result = sqlManager.createQuery(sql)
				   				   .setParameter(id)
				                   .executeQuery();

		return result > 0;
	}

}
