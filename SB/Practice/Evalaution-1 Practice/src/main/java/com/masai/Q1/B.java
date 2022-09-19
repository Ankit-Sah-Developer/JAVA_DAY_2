package com.masai.Q1;

import org.springframework.stereotype.Service;

@Service
public class B {
	
	private A a;

	public void setA(A a) {
		this.a = a;
	}
	
	public void showA() {
		a.funA();
	}
	
	public void funB(){
		System.out.println("Inside funB using showB of A");
	}
}
