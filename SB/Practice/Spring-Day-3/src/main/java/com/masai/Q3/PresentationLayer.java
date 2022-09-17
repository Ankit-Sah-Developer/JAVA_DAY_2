package com.masai.Q3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pL")
public class PresentationLayer {
	
	private ServiceLayer service;
	
	@Autowired
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
