package com.masai;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	
	public void save(Employee emp) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");
		 EntityManager em = 	emf.createEntityManager();
			
	Employee employee = new Employee(10, "ratan", "abc", 90000);
		  EntityTransaction  et =  em.getTransaction();
		  et.begin();
		  em.persist(employee);
		  et.commit();  
		 

		  System.out.println("done..");

			em.close();
		
//		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("employeeUnit");
//		EntityManager em = 	emf.createEntityManager();
//		Employee employee = new Employee(12, "rahul", "abc", 80000);
//	     em.getTransaction().begin();
//	     em.persist(employee);
//	     em.getTransaction().commit();
//
//		em.close();
//		
//		System.out.println("done..");
//		em.close();
		}
		
			
	
	
	public String getAddressOfEmployee(int empid) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");
		 EntityManager em = 	emf.createEntityManager();
		Employee employee = em.find(Employee.class, empid);
			if(employee != null) {
				System.out.println(employee);
			}
			else
			System.out.println("employee are not found");

			em.close();
			
			  return em.toString();
			}
	
	
	public String giveBonushToEmployee(int empid,int bonush) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");
		 EntityManager em = 	emf.createEntityManager();

		 
			Employee employee = em.find(Employee.class, empid);
		 if(employee == null) {
			 
			System.out.println("Employee are not found ");
		 }
		 else {
			 em.getTransaction().begin();
				employee.setSalary(employee.getSalary()+bonush);
				em.getTransaction().commit();
				System.out.println("salary is update..");

		 }
		 return em.toString();
	}
  
	
	public boolean deleteEmployee(int empid) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");
		 EntityManager em = 	emf.createEntityManager();
			Employee employee = em.find(Employee.class, empid);
			 if(employee != null) {
				  em.getTransaction().begin();
			    	em.remove(employee);
			    	em.getTransaction().commit();
			    	System.out.println("employee removed");
				
			 }
			 
			 else {
			    	System.out.println("employee are not found");
			    }

				em.close();
				
				System.out.println("done..");
				return false;
				
				
				}
		
	
	
	

	public static void main(String[] args) {
		
		Demo d1 = new Demo();
		
		
		
       //Qustion1
     //   d1.save(new Employee());
       
       //qustion2
     //  d1.getAddressOfEmployee(10);
       
       //qustion3
     //  d1.giveBonushToEmployee(90,10000);
       
       //qustion4
       d1.deleteEmployee(12);
       
	}

}
