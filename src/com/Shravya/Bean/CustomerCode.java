package com.Shravya.Bean;

import java.util.Random;

public class CustomerCode {


 
 public static void main(String[] args) {
 
 }
 
 public static String generateCustomerCode() {
  int n;
  Random r=new Random();
  n=r.nextInt(2000);
  String s=String.valueOf(n);
  return s;
  
 }
 
}

