package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.example.asso.entity.Address;
import com.example.asso.entity.Passport;
import com.example.asso.entity.Student;
import com.example.util.HibernateUtil;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class HibernatePgm {
	public static void main(String[] args) {
		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student objects
			
			Address add1 = new Address("Bihar", "10001");
			add1.setStudent(student);
			Address add2 = new Address("Maharashtra", "10002");
			add2.setStudent(student);
			List<Address> address = new ArrayList<Address>();
			address.add(add1);
			address.add(add2);
			
			Passport passport= new Passport("1234", new Date());
			passport.setStudent(student);
			
			student.setPassport(passport);
			student.setAddress(address );
			session.save(student);
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Student> students = session.createQuery("from Student", Student.class).setCacheable(true).list();
			students.forEach(s -> System.out.println(s.getFirstName()+"---"+s.getEmail()));
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		System.out.println("---------------Load from 2 cache-----------------");
		
		CacheManager instance = CacheManager.getInstance();
		Cache cache = instance.getCache("students");
		System.out.println("cache:: "+cache);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			 session.doWork(new Work() {

				@Override
				public void execute(Connection connection) throws SQLException {
	                System.out.println("The isolation level is --> " +
	                        connection.getTransactionIsolation());
				}
				 
			 });
			 
			Student student2 = session.load(Student.class, 1);
			
			Transaction transaction2 = session.beginTransaction();
			student2.setEmail("Kumar1@gmail.com");
			session.save(student2);
			student2.setEmail("Kumar2@gmail.com");
			transaction2.commit();
			
			List<Address> address = student2.getAddress();
			System.out.println("Address:: " + address);
			
			System.out.println("Student :: "+student2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		instance.shutdown();

		HibernateUtil.shutdown();
	}
}
