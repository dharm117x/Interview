package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.inh.entity.Book;
import com.example.inh.entity.Employee;
import com.example.inh.entity.Pen;
import com.example.inh.entity.Product;
import com.example.util.HibernateUtil;

public class HibePgm2 {
	public static void main(String[] args) {
		Transaction transaction = null;

		Product pr = new Product();
		pr.setName("Dummy");
		
		Book book = new Book();
		book.setName("JAVA");
		book.setAuthor("JG");
		
		Pen pen  = new Pen();
		pen.setName("RNLD");
		pen.setColor("Black");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(pr);
			session.save(book);
			session.save(pen);
			
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
