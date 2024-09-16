package com.icici.entities;

import java.util.Arrays;

public class A {
	public static void main(String[] args) {
		
		int i=123;
		int rev=0;
		System.out.println("original number is :"+i);

		while(i!=0) {
			rev=rev*10+i%10;
			i=i/10;
		}
		System.out.println("reverse number is :"+rev);

 	}

}
