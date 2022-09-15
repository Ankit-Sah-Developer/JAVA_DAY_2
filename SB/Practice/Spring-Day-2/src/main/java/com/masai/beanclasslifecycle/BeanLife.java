package com.masai.beanclasslifecycle;

public class BeanLife {

	int num;

	public void setNum(int num) {
		this.num = num;
	}

	public void initialize() {

		System.out.println("Object initialized..");

	}

	public void destroy() {

		System.out.println("Object destroyed..");

	}

	public void showNum() {

		System.out.println("Number is:- " + num);

	}
}
