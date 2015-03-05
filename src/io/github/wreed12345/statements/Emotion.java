package io.github.wreed12345.statements;

import io.github.wreed12345.Person;
import io.github.wreed12345.util.Util;

public class Emotion extends Phrase{

	public Emotion() {
		super("emotion", "I'm feeling", "I am", "I'm not feeling", "I'm");
	}
	
	private String lastEmotion;
	
	@Override
	public boolean containsPhrase(String phrase) {
		for(String s : getKeywords()){
			if(phrase.toLowerCase().contains(s.toLowerCase())) {
				String modifiedPhrase = phrase;
				modifiedPhrase = modifiedPhrase.replace(s, "");
				modifiedPhrase = modifiedPhrase.replace(" ", "");
				if(Util.isLowerCase(modifiedPhrase.toCharArray()[0])) {
					lastEmotion = modifiedPhrase;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String response(Person person) {
		person.getEmotions().add(lastEmotion);
		return "Why are you " + lastEmotion + "?";
	}
	//http://www.alicebot.org/aiml/aaa/
}
