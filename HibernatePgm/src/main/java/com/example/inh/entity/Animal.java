package com.example.inh.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long animalId;
	
	@Basic(optional = false)
	private String species;

	public long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(long animalId) {
		this.animalId = animalId;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

}