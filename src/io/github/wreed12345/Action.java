package io.github.wreed12345;

public class Action extends Phrase{

	public Action() {
		super("Action", "I'm doing");
	}

	@Override
	public boolean containsPhrase(String phrase) {
		return false;
	}

	@Override
	public String response(Person person) {
		return "Why are you doing that?";
	}

}

//http://www.sentimap.com/
//	www.nltk.org
//	http://alias-i.com/lingpipe/index.html
//		http://www.programcreek.com/2012/05/opennlp-tutorial/