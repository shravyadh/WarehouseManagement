package com.Shravya.Bean;

import java.util.Random;

public class AdminCode {
	public static void main(String[] args) {
		 
	 }
	 
	 public static String generateAdminCode() {
	  int n;
	  Random r=new Random();
	  n=r.nextInt(1000);
	  String s=String.valueOf(n);
	  return s;
	  
	 }
}
