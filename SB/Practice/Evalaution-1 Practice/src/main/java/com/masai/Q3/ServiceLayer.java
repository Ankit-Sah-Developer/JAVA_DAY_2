package com.masai.Q3;

import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
	
	public void rectangleArea(double a, double b) {
		
		System.out.println("The area of the rectangle is: " + (a*b));
	}
	
	public void circleArea(double c) {
		
		System.out.println("The area of the rectangle is: " + (3.14 * (c*c)));
	}
	
	public void squareArea(double s) {
		
		System.out.println("The area of the rectangle is: " + ((s*s)));
	}
	
	public void triangleArea(double b, double h) {
		
		System.out.println("The area of the rectangle is: " + (0.5*b*h));
	}
}
