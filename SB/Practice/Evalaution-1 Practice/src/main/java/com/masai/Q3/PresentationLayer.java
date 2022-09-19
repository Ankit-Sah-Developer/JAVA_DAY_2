package com.masai.Q3;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pL")
public class PresentationLayer {
	
	Scanner sc = new Scanner(System.in);
	
	@Autowired
	private ServiceLayer sL;

	public void setsL(ServiceLayer sL) {
		this.sL = sL;
	}
	
	public void calculateArea(String s) {
		
		s = s.toLowerCase();
		
		switch (s) {
			case "triangle":
				System.out.println("Enter base of trinagle");
				double b = sc.nextDouble();
				System.out.println("EnterS hieght of trinagle");
				double h = sc.nextDouble();
				sL.triangleArea(b, h);
				break;
				
			case "circle":
				System.out.println("Enter radius of circle");
				double c = sc.nextDouble();
				sL.circleArea(c);
				break;
			
			case "square":
				System.out.println("Enter side of square");
				double si = sc.nextDouble();
				sL.squareArea(si);
				break;
			case "rectangle":
				System.out.println("Enter breadth of rectangle");
				double a = sc.nextDouble();
				System.out.println("Enter height of rectangle");
				double be = sc.nextDouble();
				sL.rectangleArea(a, be);
				break;
	
			default:
				System.out.println("Invalid shape..");
				break;
		}
	}
	
}
