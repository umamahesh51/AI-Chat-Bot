package io.github.wreed12345;

import java.util.ArrayList;

public class Person {
	private ArrayList<String> emotions = new ArrayList<>();
	private int age;
	private String name;
	private Gender gender;
	private String dogsName;
	private ArrayList<Person> familyMembers = new ArrayList<>();

	public enum Gender {
		MALE, FEMALE;
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
