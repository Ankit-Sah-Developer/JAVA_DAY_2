package com.masai.Q1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
	
	public static void main(String[] args) {
		
		ApplicationContext act = new AnnotationConfigApplicationContext(AppContext.class);
		
		A a = act.getBean("a",A.class);
		
		a.setB(new B());
		
		a.showB();
		a.funA();
	}

}
