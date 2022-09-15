package com.masai.beanclasslifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
//	**Bean Life Cycle:-
		
//		1.Does Not Exist Phase:- Bean class is not exist initially until the container loads the xml file (applicationContext.xml)
//								 with all the bean class references if the bean is in singleton scope;
//								 If bean is in prototype scope the object of bean will be available only or initiated when
//								 we pull the object the from the container
	
//		2.Instantiation phase:-  In the instantiation the spring container find the dependencies and uses the dependency Injection
//								 and create the bean class objects loading it into the memory
	
//		3.Initialization phase:- In Initialization phase the spring container initialize the objects for caller to use, And if
//								 there is any user defined method found it will called first and then the objects are initialize
//								 till then the objects are not available for the operations
	
//		4.Service phase:-        In this phase the objects which are initialize are ready to use 
	
//		5.Destruction phase:-    In this phase all the beans registered with spring container will destroy and spring container
//								 will give up all the beans class when any user defined destroy method is configured with container
//								 it will eligible for the garbage collector after that
	
	
	
	
	public static void main(String[] args) {
		
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BeanLife bL = act.getBean("bL",BeanLife.class);
		
		bL.showNum();
		
		ClassPathXmlApplicationContext act2 = (ClassPathXmlApplicationContext)act;
		act2.close();

	}
	
}	
