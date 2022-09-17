package com.masai.Q2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext act = new AnnotationConfigApplicationContext(AppConfig2.class);
		
		PrintData pd = act.getBean("pD",PrintData.class);
		
		pd.printData();
		
	}

}
