package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.inh.entity.Animal;
import com.example.inh.entity.Pet;
import com.example.util.HibernateUtil;

public class HibePgm3 {
	public static void main(String[] args) {
		Transaction transaction = null;

		Animal an = new Animal();
		an.setSpecies("DOG");
		
		Pet p =new Pet();
		p.setSpecies("DOG");
		p.setName("Moti");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(an);
			session.save(p);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Pet> students = session.createQuery("from Pet", Pet.class).list();
			students.forEach(s -> System.out.println(s.getName()));
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		HibernateUtil.shutdown();
	}
}
