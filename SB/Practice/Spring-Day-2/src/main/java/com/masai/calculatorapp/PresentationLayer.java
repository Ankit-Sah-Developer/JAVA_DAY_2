package com.masai.calculatorapp;

public class PresentationLayer {
	
	private ServiceLayer service;

	public void setService(ServiceLayer service) {
		this.service = service;
	}
	
	public void calculate(double num1, double num2, String operator) {
		
		char op = operator.charAt(0);
		
		if(!(op == '+' || op == '-' || op == '*' || op == '/')){
			System.out.println("Invalid operator..");
		}
		else if(op == '/' && num2 == 0.0) {
			System.out.println("Can't divide by 0");
		}else {
			service.operation(num1, num2, op);
		}
	}
}
