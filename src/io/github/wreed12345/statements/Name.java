package io.github.wreed12345.statements;

import io.github.wreed12345.Person;
import io.github.wreed12345.util.Util;

public class Name extends Phrase{

	public Name() {
		super("name", "My name is", "Call me", "I am", "I'm");
	}

	private String lastName;
	
	@Override
	public boolean containsPhrase(String phrase) {
		for(String s : getKeywords()){
			if(phrase.toLowerCase().contains(s.toLowerCase())) {
				String modifiedPhrase = phrase;
				modifiedPhrase = modifiedPhrase.replace(s, "");
				modifiedPhrase = modifiedPhrase.replace(" ", "");
				if(Util.isUpperCase(modifiedPhrase.toCharArray()[0])) {
					lastName = modifiedPhrase;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String response(Person person) {
		person.setName(lastName);
		return null;
	}
	
	

}
