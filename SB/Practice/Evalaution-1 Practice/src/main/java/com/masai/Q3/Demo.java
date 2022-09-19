package com.masai.Q3;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		ApplicationContext act = new AnnotationConfigApplicationContext(AppConfigue.class);
		
		PresentationLayer pL = act.getBean("pL",PresentationLayer.class);
		
		System.out.println("Enter the shape for calculating area:- 'Triangle','Circle','Square','Rectangle'");
		
		String s = sc.next();
		
		pL.calculateArea(s);
		
		
	}
}
