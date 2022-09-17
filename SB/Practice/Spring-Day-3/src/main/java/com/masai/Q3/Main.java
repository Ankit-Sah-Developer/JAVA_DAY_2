package com.masai.Q3;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ApplicationContext act = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PresentationLayer pL =  act.getBean("pL",PresentationLayer.class);
		
		
		System.out.println("Enter the first number : ");
		double num1 = sc.nextDouble();
		
		System.out.println("Enter the operation/operator : '+' or '-' or '*' or '/'");
		String operator = sc.next();
		
		System.out.println("Enter the second number : ");
		double num2 = sc.nextDouble();
		
		pL.calculate(num1, num2, operator);
		
	}
}
