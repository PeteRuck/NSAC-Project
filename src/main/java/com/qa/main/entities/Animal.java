package com.qa.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String commonName;
	
	@Column(nullable = false)
	private String genus;
	
	@Column(nullable = false)
	private float size;
	
	@Column(nullable = false)
	private String typeGenus;
	
	public Animal() {
        super();
    }
	
	public Animal(String commonName, String genus, float size, String typeGenus) {
		super();
		this.commonName = commonName;
		this.genus = genus;
		this.size = size;
		this.typeGenus = typeGenus;
	}
	
	public Animal(long id, String commonName, String genus, float size, String typeGenus) {
		super();
		this.id = id;
		this.commonName = commonName;
		this.genus = genus;
		this.size = size;
		this.typeGenus = typeGenus;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public String getTypeGenus() {
		return typeGenus;
	}

	public void setTypeGenus(String typeGenus) {
		this.typeGenus = typeGenus;
	}

	
	
}
