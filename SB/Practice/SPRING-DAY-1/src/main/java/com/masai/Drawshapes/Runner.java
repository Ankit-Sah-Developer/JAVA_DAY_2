package com.masai.Drawshapes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
	
	public static void main(String[] args) {
		
		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		apx.getBean(Triangle.class,"tr").draw();
		apx.getBean(Circle.class,"c").draw();
		apx.getBean(Cylinder.class,"cy").draw();
		
	}
	
}
