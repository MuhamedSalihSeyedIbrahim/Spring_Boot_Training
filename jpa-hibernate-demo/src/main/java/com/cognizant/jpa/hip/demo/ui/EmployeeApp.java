package com.cognizant.jpa.hip.demo.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.cognizant.jpa.hip.demo.model.Employee;
import com.cognizant.jpa.hip.demo.util.JPAUtil;

public class EmployeeApp {
	
	public static void  main(String args[]) {
		Scanner scan=new Scanner(System.in);
		
		Employee e=new Employee();
		System.out.print("Emp ID : ");
		e.setEmpId(scan.nextInt());
		System.out.print("Name : ");
		e.setEmpName(scan.next());
		System.out.print("Basic : ");
		e.setBasic(scan.nextDouble());
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		System.out.println("Data Saved");
		JPAUtil.shutdown();
		scan.close();
		
		
	}

}
