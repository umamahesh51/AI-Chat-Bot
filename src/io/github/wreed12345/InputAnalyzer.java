package io.github.wreed12345;

import java.util.ArrayList;

import io.github.wreed12345.statements.Age;
import io.github.wreed12345.statements.Emotion;
import io.github.wreed12345.statements.Name;
import io.github.wreed12345.statements.Phrase;

/**
 * Analyzes and handles input for text entered when not in a question sequence.
 * These could be questions or statements 
 */
public class InputAnalyzer {
	private ArrayList<Phrase> phrases;
	private Person person;
	
	/**
	 * Creates the InputAnalyzer
	 * @param person the profile of the person talking
	 */
	public InputAnalyzer(Person person) {
		phrases = new ArrayList<Phrase>();
		phrases.add(new Name());
		phrases.add(new Age());
		phrases.add(new Emotion());
		this.person = person;

	}
	
	public void handleText(String input) {
		PHRASE: for (Phrase p : phrases)
			for (String s : p.getKeywords())
				if (input.contains(s))
					if (p.containsPhrase(input)) {
						// System.out.println(p.getName());
						System.out.println(p.response(person));
						break PHRASE;
					}
	}
}
