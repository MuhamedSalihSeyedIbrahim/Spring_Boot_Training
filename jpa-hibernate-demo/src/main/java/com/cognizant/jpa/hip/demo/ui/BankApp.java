package com.cognizant.jpa.hip.demo.ui;

import javax.persistence.EntityManager;

import com.cognizant.jpa.hip.demo.model.onetonone.BankAccount;
import com.cognizant.jpa.hip.demo.model.onetonone.customer;
import com.cognizant.jpa.hip.demo.util.JPAUtil;

public class BankApp {
	
	public static void main(String args[])
	{
		BankAccount ba=new BankAccount();
		ba.setAccno("4564684364");
		customer cs=new customer("46847364","sdf",ba);
		ba.setCustomer(cs);
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(cs);
		em.getTransaction().commit();
		
		System.out.println("Data Saved");
		JPAUtil.shutdown();
		
	}
}
