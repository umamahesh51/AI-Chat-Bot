package io.github.wreed12345;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Phrase {

	private ArrayList<String> keywords = new ArrayList<String>();
	//private Object value;
	private String name;
	
	public Phrase (String name, String... keywords) {
		this.name = name;
		this.keywords = new ArrayList<String>(Arrays.asList(keywords));
	}

//	public void setValue(Object value) {
//		this.value = value;
//	}
//
//	public Object getValue() {
//		return value;
//	}

	public ArrayList<String> getKeywords() {
		return keywords;
	}

	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}
	
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String response(Person person);
	
	public abstract boolean containsPhrase(String phrase);
}
 