package com.chc.demo;

public class Demo {

	long a;
	long b;

	public Demo(long a, long b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Demo() {
	};

	// True if sum is even
	public boolean isEven() {
		return ((a + b) % 2 == 0) ? true : false;
	}

	// return sum
	public long sum() {
		return a + b;
	}

	@Override
	public String toString() {
		return "Demo [a=" + a + ", b=" + b + "]";
	}

}
