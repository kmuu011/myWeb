package com.ict.erp;

import java.util.Arrays;

public class Person {

	private String name;
	private int age;
	private String[] hobby;
	
	

	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	

	
	
}
