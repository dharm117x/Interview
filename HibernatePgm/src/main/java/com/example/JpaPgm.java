package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.example.asso.entity.Address;
import com.example.asso.entity.Student;
import com.example.util.JPAUtil;

import net.sf.ehcache.CacheManager;

public class JpaPgm {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = JPAUtil.getEMFactory();
		EntityManager em = emFactory.createEntityManager();
		
		CacheManager manager = CacheManager.getInstance();
		List<CacheManager> list = manager.ALL_CACHE_MANAGERS;

		try {

			System.out.println("-----save----");
			
			save(em);
			
			System.out.println("-----load 1----");
			
			System.out.println(getStudent(em));
			
			System.out.println("-----merge----");
			
			mergeStudent(em);
			
			System.out.println("-----load 2----");
			
			System.out.println(getStudent(em));
			System.out.println("-----display----");

			List<Student> student = queryForStudent(em);
			student.forEach(System.out::println);

			System.out.println("-----display2----");

			List<Student> students = queryForStudent(em);
			students.forEach(System.out::println);

			System.out.println("------Delete-------");
//			detach(em, student.get(0));
//			delete(em, student.get(0));
	
		} finally {
			CacheManager.getInstance().shutdown();
			emFactory.close();
		}
			
	}

	private static void save(EntityManager em) {
		Student student = new Student("Dharmendra", "Fadatare", "rameshfadatare@javaguides.com");
		Address add = new Address("MHarahtra", "1000");
		add.setStudent(student);
		student.getAddress().add(add);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(student);
		
		transaction.commit();
	}

	private static void detach(EntityManager em, Student stu) {
		em.detach(stu);
	}

	private static void delete(EntityManager em, Student stu) {
		em.getTransaction().begin();
		em.remove(stu);
		em.getTransaction().commit();
	}

	private static Student getStudent(EntityManager em) {
		return em.find(Student.class, 1);
	}

	private static void mergeStudent(EntityManager em) {
		Student student = getStudent(em);
		detach(em, student);
		student.setEmail("dk@gmail.com");
		
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
	}

	private static List<Student> queryForStudent(EntityManager em) {
	    List<Student> movies = em.createQuery("from Student order by id", Student.class).setHint("org.hibernate.cacheable", true)
	      .getResultList();
	    return movies;
	}


}
