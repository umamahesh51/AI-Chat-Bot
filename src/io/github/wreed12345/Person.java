package io.github.wreed12345;

import java.util.ArrayList;

public class Person {
	//need to make this manageable across threads
	private ArrayList<String> emotions = new ArrayList<>();
	private int age;
	private String name = "unknown";
	private Gender gender = Gender.UNKOWN;
	private String dogsName = "unkown";
	private ArrayList<Person> familyMembers = new ArrayList<>();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Profile for " + name + "\n");
		sb.append("Age:\t\t" + age + "\n");
		sb.append("Gender:\t\t" + gender + "\n");
		sb.append("Dog's name:\t" + dogsName + "\n");
		for(String s : emotions) 
			sb.append("Emotion:\t" + s + "\n");
		for(Person p : familyMembers) 
			sb.append("Family Member:\t" + p.getName() + "\n");
		return sb.toString();
	}
	
	public enum Gender {
		MALE, FEMALE, UNKOWN;
	}
	
	public ArrayList<String> getEmotions() {
		return emotions;
	}

	public void setEmotions(ArrayList<String> emotions) {
		this.emotions = emotions;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDogsName() {
		return dogsName;
	}

	public void setDogsName(String dogsName) {
		this.dogsName = dogsName;
	}

	public ArrayList<Person> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(ArrayList<Person> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
