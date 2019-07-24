package com.cognizant.jpa.hip.demo.ui;

import javax.persistence.EntityManager;

import com.cognizant.jpa.hip.demo.model.isa.ContractEmp;
import com.cognizant.jpa.hip.demo.model.isa.Emp;
import com.cognizant.jpa.hip.demo.model.isa.Manager;
import com.cognizant.jpa.hip.demo.util.JPAUtil;

public class EmployeeAppIsA {
	
	public static void main(String args[]) {
		
		Emp e=new Emp(1,"Vamsy",4567);
		Manager m=new Manager(102,"Ram",4564,456);
		ContractEmp ce=new ContractEmp(123,"fsdf",4654,456);
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.persist(m);
		em.persist(ce);
		em.getTransaction().commit();
		
		System.out.println("Data Saved");
		JPAUtil.shutdown();
	}

}
