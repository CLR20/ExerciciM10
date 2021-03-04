package com.lambdas.domain;

import java.util.ArrayList;
import java.util.List;

public class Students {
	
	private String name;
	private int age;
	private String course;
	private double qualification;
	List <Students> studentsList = new ArrayList <Students>();
	
	public Students() {}
	
	public Students (String name, int age, String course, int qualification) {
		this.name = name;
		this.age = age;
		this.course = course;
		this.qualification = qualification;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}
	
	public void setCourse(String c) {
		course = c;
	}
	
	public void setQualification(double q) {
		qualification = q;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getCourse() {
		return course;
	}
	
	public double getQualification() {
		return qualification;
	}
	
	@Override
	public String toString() {
		return "\nName: " + name + ", Age: " + age + ", Course: " + course 
				+ ", Qualification: " + qualification;
	}

}
