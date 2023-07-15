package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.inh.entity.Employee;
import com.example.util.HibernateUtil;

public class HibePgm1 {
	public static void main(String[] args) {
		Transaction transaction = null;

		Employee emp = new Employee();
		emp.setName("Dkumar");
		emp.setCompany("Ingram");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student objects
			session.save(emp);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Employee> students = session.createQuery("from Employee", Employee.class).list();
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
