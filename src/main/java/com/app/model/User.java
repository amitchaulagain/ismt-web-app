package com.app.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String country;
	private boolean male;
	private String gender;
	private String courses;



	public User() {
	}

	public User(int id, String name, String email, String password, String country) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
		if(male){
			this.gender="Male";
		}
		else {
			this.gender="Female";
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}
}
