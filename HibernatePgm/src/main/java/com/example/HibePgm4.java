package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.inh.entity.Car;
import com.example.inh.entity.Vehicle;
import com.example.util.HibernateUtil;

public class HibePgm4 {
	public static void main(String[] args) {
		Transaction transaction = null;

		Vehicle v = new Vehicle();
		v.setManufacturer("BMW");
		
		Car c = new Car();
		c.setManufacturer("BMW");
		c.setName("CAR");
		c.setType("Four wheeler");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(c);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Car> students = session.createQuery("from Car", Car.class).list();
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
