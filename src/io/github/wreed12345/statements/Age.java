package io.github.wreed12345.statements;

import io.github.wreed12345.Person;
import io.github.wreed12345.Util;

public class Age extends Phrase{

	public Age() {
		super("age", "I am", "I'm", "years old", "I was born on", "I was born in", "My age is");
	}
	private int lastAge;

	@Override
	public boolean containsPhrase(String phrase) {
		for(String s : getKeywords()){
			if(phrase.toLowerCase().contains(s.toLowerCase())) {
				String modifiedPhrase = phrase;
				modifiedPhrase = modifiedPhrase.replace(s, "");
				modifiedPhrase = modifiedPhrase.replace(" ", "");
				if(Util.isDigit(modifiedPhrase.toCharArray()[0])) {
					lastAge = Integer.valueOf(modifiedPhrase);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String response(Person person) {
		person.setAge(lastAge);
		return "What is it like being " + lastAge + "?";
	}

}
