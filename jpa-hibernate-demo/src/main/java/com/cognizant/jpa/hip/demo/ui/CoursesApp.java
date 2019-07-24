package com.cognizant.jpa.hip.demo.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;

import com.cognizant.jpa.hip.demo.model.onetomany.Course;
import com.cognizant.jpa.hip.demo.model.onetomany.Trainee;
import com.cognizant.jpa.hip.demo.util.JPAUtil;

public class CoursesApp {
	
	public static void main(String args[]) {
		Course mca= new Course(101,"MCA",new TreeSet<Trainee>());
		Course mba= new Course(102,"MBA",new TreeSet<Trainee>());
		
		mca.getTrainees().add(new Trainee(201,"fddfs",mca));
		mca.getTrainees().add(new Trainee(202,"fddfs",mca));
		mca.getTrainees().add(new Trainee(203,"fddfs",mca));
		
		mba.getTrainees().add(new Trainee(204,"fasdf",mba));
		mba.getTrainees().add(new Trainee(205,"gasdga",mba));
		mba.getTrainees().add(new Trainee(206,"fahhdffh",mba));
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(mca);
		em.persist(mba);
		em.getTransaction().commit();
		
		System.out.println("Data Saved");
		JPAUtil.shutdown();
		
	}

}
