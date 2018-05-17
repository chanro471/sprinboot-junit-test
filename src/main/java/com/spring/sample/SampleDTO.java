package com.spring.sample;

import java.util.List;

public class SampleDTO {

	private String name;
	
	private String id;
	
	private String city;
	
	private List<String> projects;

	public SampleDTO(){
		
	}
	
	public SampleDTO(String name, String id, String city) {
		super();
		this.name = name;
		this.id = id;
		this.city = city;
	}

	@Override
	public String toString() {
		return "SampleDTO [name=" + name + ", id=" + id + ", city=" + city + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	
	
}
