package com.tsrtc.registration.testscripts;

import java.util.ArrayList;
import java.util.List;

public class Test2 extends Test1{
	
	public void display() {
		super.display();
		//System.out.println("Derived class");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Test1 t1 = new Test1();
		t1.display();
		
		Test2 t2 = new Test2();
		t2.display();*/
		
		Test2 t1 = new Test2();
		t1.display();
		
		String name = "Venkat";
		System.out.println("name length "+name.length());
		System.out.println("name length "+name.toUpperCase());
		System.out.println("name length "+name.toLowerCase());
		System.out.println("name length "+name.concat("Geesidi"));
		System.out.println("name length "+name.substring(1, 2));
		
		List<String> list = new ArrayList<String>();
		list.add("Suresh");
	}
}
