package com.masai.calculatorapp;

public class ServiceLayer {

	public void operation(double num1, double num2, char operator) {
		
		switch (operator) {
		    case '+':
		        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		        break;
		    case '-':
		        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		        break;
		    case '*':
		        System.out.println(num1 + " x " + num2 + " = " + (num1 * num2));
		        break;
		    case '/':
		        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		        break;
		    default:
		        System.err.println("Invalid Operator..");
		        break;
		}
		
	}
	

	
}
