package com.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UN");
	
	public static EntityManagerFactory getEMFactory() {
		return emf;
	}
	
}
