package io.github.wreed12345;

import io.github.wreed12345.statements.Age;
import io.github.wreed12345.statements.Emotion;
import io.github.wreed12345.statements.Name;
import io.github.wreed12345.statements.Phrase;
import io.github.wreed12345.util.OutputOverrider;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatBot {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Phrase> phrases = new ArrayList<Phrase>();
		
		//change output
		PrintStream origOut = System.out;
	    PrintStream interceptor = new OutputOverrider(origOut);
	    System.setOut(interceptor);
	    System.out.println("AI Chat Bot started...");

		Phrase name = new Name();
		Phrase age = new Age();
		Phrase emotion = new Emotion();
		phrases.add(name);
		phrases.add(age);
		phrases.add(emotion);

		Person person = new Person();
		QuestionAsker qa = new QuestionAsker();//.run();
		new Thread(qa).start();
		
		while (scanner.hasNextLine()) {
			String enteredWord = scanner.nextLine();

			// if all caps yell at user

			// ....
			PHRASE: for (Phrase p : phrases)
				for (String s : p.getKeywords())
					if (enteredWord.contains(s))
						if (p.containsPhrase(enteredWord)) {
							// System.out.println(p.getName());
							System.out.println(p.response(person));
							break PHRASE;
						}
			qa.resetTime();
		}
	}
	
	private enum Mode {
		ASKING, QUESTIONING;
	}
}
