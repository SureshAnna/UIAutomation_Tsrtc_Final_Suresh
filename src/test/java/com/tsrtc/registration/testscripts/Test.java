package com.tsrtc.registration.testscripts;

public class Test {

	public int add(int a, int b) {
		int c = a + b;
		return c;
	}
	
	public float add(float a, float b) {
		float c = a + b;
		return c;
	}

	public int add(int a, int b, int c) {
		int d = a + b + c;
		return d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
		test.add(10, 20);
		test.add(20, 30);
		
		System.out.println("test");
	}

}
