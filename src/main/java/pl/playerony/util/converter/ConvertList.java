package pl.playerony.util.converter;

import java.util.LinkedList;
import java.util.List;

import pl.playerony.model.Converter;
import pl.playerony.model.impl.Article;
import pl.playerony.model.impl.Comment;
import pl.playerony.model.impl.Role;
import pl.playerony.model.impl.User;
import pl.playerony.util.GenericClass;

public class ConvertList {
	public static List<Role> castObjectArrayToRoleList(List<Object[]> objectArray) {
		List<Role> result = new LinkedList<>();
		
		if(objectArray != null)
			for(Object[] array : objectArray) {
				Role role = new Role(array);
				result.add(role);
			}
		
		return result;
	}
	
	public static List<User> castObjectArrayToUserList(List<Object[]> objectArray) {
		List<User> result = new LinkedList<>();
		
		if(objectArray != null)
			for(Object[] array : objectArray) {
				User user = new User(array);
				result.add(user);
			}
		
		return result;
	}
	
	public static List<Comment> castObjectArrayToCommentList(List<Object[]> objectArray) {
		List<Comment> result = new LinkedList<>();
		
		if(objectArray != null)
			for(Object[] array : objectArray) {
				Comment comment = new Comment(array);
				result.add(comment);
			}
		
		return result;
	}
	
	public static List<Article> castObjectArrayToArticleList(List<Object[]> objectArray) {
		List<Article> result = new LinkedList<>();
		
		if(objectArray != null)
			for(Object[] array : objectArray) {
				Article article = new Article(array);
				result.add(article);
			}
		
		return result;
	}
}
