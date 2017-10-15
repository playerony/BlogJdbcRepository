package pl.playerony.util.converter;

import pl.playerony.model.Article;
import pl.playerony.model.Comment;
import pl.playerony.model.Role;
import pl.playerony.model.User;

public class Converter {
	public static Role castObjectArrayToRole(Object[] objectArray) {
		Long id = Long.parseLong(objectArray[0].toString());
		String name = objectArray[1].toString();

		return new Role(id, name);
	}
	
	public static User castObjectArrayToUser(Object[] objectArray) {
		Long id = Long.parseLong(objectArray[0].toString());
		String login = objectArray[1].toString();
		String password = objectArray[2].toString();
		Long roleId = Long.parseLong(objectArray[3].toString());

		return new User(id, login, password, roleId);
	}
	
	public static Comment castObjectArrayToComment(Object[] objectArray) {
		Long id = Long.parseLong(objectArray[0].toString());
		String content = objectArray[1].toString();
		Long articleId = Long.parseLong(objectArray[2].toString());
		Long userId = Long.parseLong(objectArray[3].toString());
		Integer likes = Integer.parseInt(objectArray[4].toString());
		Integer dislikes = Integer.parseInt(objectArray[5].toString());

		return new Comment(id, content, articleId, userId, likes, dislikes);
	}
	
	public static Article castObjectArrayToArticle(Object[] objectArray) {
		Long id = Long.parseLong(objectArray[0].toString());
		String title = objectArray[1].toString();
		String content = objectArray[2].toString();
		Long userId = Long.parseLong(objectArray[3].toString());

		return new Article(id, title, content, userId);
	}
}
