package com.cognizant.jpa.hip.demo.ui;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.EntityManager;

import com.cognizant.jpa.hip.demo.model.compositepk.Student;
import com.cognizant.jpa.hip.demo.model.compositepk.StudentIdentity;
import com.cognizant.jpa.hip.demo.util.JPAUtil;

public class StudentApp {
	public static void main(String args[]) {
		Student s=new Student(new StudentIdentity(1,'A',7),"Sakthi","Bala",new Date().toString());
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
		System.out.println("Data Saved");
		JPAUtil.shutdown();
		
	}

}
