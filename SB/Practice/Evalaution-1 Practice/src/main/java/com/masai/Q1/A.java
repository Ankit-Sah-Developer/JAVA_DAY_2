package com.masai.Q1;

import org.springframework.stereotype.Service;

@Service
public class A {
	
	private B b;

	public void setB(B b) {
		this.b = b;
	}
	
	public void showB() {
		b.funB();
	}
	
	public void funA(){
		System.out.println("Inside funA using showA of B");
	}
}
