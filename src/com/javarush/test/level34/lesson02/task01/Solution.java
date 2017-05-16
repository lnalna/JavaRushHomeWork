package com.javarush.test.level34.lesson02.task01;

/*
Почитать про числа Фибоначчи.
Реализовать логику метода fibonacci,
где n - это номер элемента в последовательности Фибоначчи.

*/

public class Solution {


public static void main(String[] args){
	
	
  System.out.println(fibonacci(10));

}

	public static int fibonacci(int n) {
    	if (n == 1) return 1;
    	if (n == 2) return 1;

   	 	return fibonacci(n - 1) + fibonacci(n - 2);
	}

}