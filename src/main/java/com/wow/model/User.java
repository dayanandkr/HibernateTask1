package com.wow.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String nationality;

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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String nationality) {
		super();
		this.id = new Random().nextInt(10000);
		this.name = name;
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nationality=" + nationality + "]";
	}
	
	
	
	
}
