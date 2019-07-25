package com.cognizant.jpa.hip.demo.ui;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;

import com.cognizant.jpa.hip.demo.model.Bank;
import com.cognizant.jpa.hip.demo.model.HouseLoan;
import com.cognizant.jpa.hip.demo.model.Loan;
import com.cognizant.jpa.hip.demo.model.PersonalLoan;
import com.cognizant.jpa.hip.demo.model.VehicleLoan;
import com.cognizant.jpa.hip.demo.util.JPAUtil;

public class BankApp {
	
	public static void main(String args[])
	{
		
		

		Bank customer1 = new Bank(100,"Muhamed","100020003000",new ArrayList<Loan>(), "ICICI"),
			 customer2 = new Bank(101,"Aswin","100020003001",new ArrayList<Loan>(), "SBI"),
			 customer3 = new Bank(102,"Shanmukh","100020003002",new ArrayList<Loan>(), "BOI");
		
		
		
		Loan plA  = new PersonalLoan("1000", customer2, LocalDate.now(), LocalDate.now(),500.50,5.50, 5000.50),
			 hlA1 = new HouseLoan("2000", customer2, LocalDate.now(), LocalDate.now(), 3700.20,350.20, "TVM", "CHN","L&T"),
			 vLA1 = new VehicleLoan("3000",customer2, LocalDate.now(), LocalDate.now(), 2500.30,230.30, "M-15","IND"),
			
			 hlS  = new HouseLoan("4000", customer3, LocalDate.now(), LocalDate.now(), 3700.20,350.20,"TVM", "CHN","L&T"),
			 vLM  = new VehicleLoan("5000",customer1, LocalDate.now(), LocalDate.now(), 2500.30,230.30, "M-15","IND");
	
		//one to many mapping 
			//M
			customer1.getLoans().add(vLM);
			
			//A
			customer2.getLoans().add(plA);
			customer2.getLoans().add(hlA1);
			customer2.getLoans().add(vLA1);
			
			//S
			customer3.getLoans().add(hlS);
		
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		em.persist(customer1);
		em.persist(customer2);
		em.persist(customer3);
		
		System.out.println("Data Saved");
		em.getTransaction().commit();
		JPAUtil.shutdown();
		
	}
}
