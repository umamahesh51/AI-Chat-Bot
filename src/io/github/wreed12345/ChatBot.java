package io.github.wreed12345;

import io.github.wreed12345.util.OutputOverrider;

import java.io.PrintStream;
import java.util.Scanner;

public class ChatBot {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//change output
		PrintStream origOut = System.out;
	    PrintStream interceptor = new OutputOverrider(origOut);
	    System.setOut(interceptor);
	    System.out.println("AI Chat Bot started...");

		Person person = new Person();
		//QuestionAsker qa = new QuestionAsker();//.run();
		//new Thread(qa).start();
		
		InputAnalyzer ia = new InputAnalyzer(person);
		
		while (scanner.hasNextLine()) {
			String enteredWord = scanner.nextLine();
			
			if(enteredWord.equals("/person")) {
				System.out.println(person);
				continue;
			}
			
			ia.handleText(enteredWord);
			
//			qa.resetTime();
//			if(qa.isNotAsking()) {
//				qa.startAsking();
//			}
		}
		scanner.close();
	}
	
	//dont think this is necessary because of QuestionAsker questioning boolean
	private enum Mode {
		ASKING, QUESTIONING;
	}
}
