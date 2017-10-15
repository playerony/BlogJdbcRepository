package pl.playerony.util.converter;

import java.util.LinkedList;
import java.util.List;

import pl.playerony.model.Article;
import pl.playerony.model.Comment;
import pl.playerony.model.Role;
import pl.playerony.model.User;

public class ConvertList {
	public static List<Role> castListOfObjectsToRoles(List<Object[]> objectArray) {
		List<Role> result = new LinkedList<>();
		
		for(Object[] array : objectArray) {
			Role role = Converter.castObjectArrayToRole(array);
			result.add(role);
		}
		
		return result;
	}
	
	public static List<User> castListOfObjectsToUsers(List<Object[]> objectArray) {
		List<User> result = new LinkedList<>();
		
		for(Object[] array : objectArray) {
			User user = Converter.castObjectArrayToUser(array);
			result.add(user);
		}
		
		return result;
	}
	
	public static List<Comment> castListOfObjectsToComments(List<Object[]> objectArray) {
		List<Comment> result = new LinkedList<>();
		
		for(Object[] array : objectArray) {
			Comment comment = Converter.castObjectArrayToComment(array);
			result.add(comment);
		}
		
		return result;
	}
	
	public static List<Article> castListOfObjectsToArticles(List<Object[]> objectArray) {
		List<Article> result = new LinkedList<>();
		
		for(Object[] array : objectArray) {
			Article article = Converter.castObjectArrayToArticle(array);
			result.add(article);
		}
		
		return result;
	}
}
