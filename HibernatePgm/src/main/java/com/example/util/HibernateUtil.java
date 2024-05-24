package com.example.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import jakarta.persistence.Cache;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();
				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);
				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();
				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static Properties propertyLoad() {
		Properties properties = null;
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(HibernateUtil.class.getResourceAsStream("/config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
	}

	public static Cache getCache() {
		return sessionFactory.getCache();
	}

	public static void shutdown() {
		if (registry != null) {
			System.out.println("HibernateUtil.shutdown()");
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public static SessionFactory getSessionFactory_OLD() {

		return sessionFactory;
	}
}
