package com.javarush.test.level05.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их сумму на экран.
*/

public class Solution
{
   public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string_a = reader.readLine();
        String string_b = reader.readLine();
        int a = Integer.parseInt(string_a);
        int b = Integer.parseInt(string_b);
        int sum = 0;
        sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
//int num1=Integer.parseInt(string1);