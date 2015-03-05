package io.github.wreed12345;

public class Util {
	public static final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

	public static boolean isVowel(char ch) {
	    for (char vowel : VOWELS) {
	        if (vowel == ch) {
	            return true;
	        }
	    }
	    return false;
	}

	public static boolean isDigit(char ch) {
	    return ch >= '0' && ch <= '9';
	}

	public static boolean isLowerCase(char ch) {
	    return ch >= 'a' && ch <= 'z';
	}

	public static boolean isUpperCase(char ch) {
	    return ch >= 'A' && ch <= 'Z';
	}
	
	public static void removePunctuation(String s) {
		s = s.replace(".", "");
		s = s.replace(",", "");
		s = s.replace("?", "");
		s = s.replace("!", "");
	}

	//TODO: strip punctuation method
}
