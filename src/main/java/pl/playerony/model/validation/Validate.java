package pl.playerony.model.validation;

public class Validate {
	public static boolean checkNumbersInString(String phrase) {
		String regex = "^[a-zA-Z]+$";
		if (phrase.matches(regex))
			return true;
		else
			return false;
	}
	
	public boolean checkInt(Integer num) {
	 	String regex = "[0-9]+";
		if (num.toString().matches(regex))
			return true;
		else
			return false;
	}
}
