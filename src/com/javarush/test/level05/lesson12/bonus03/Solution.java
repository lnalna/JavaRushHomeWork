package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string1 = reader.readLine();
        int N = Integer.parseInt(string1);
        int maximum = 0;

        //напишите здесь ваш код

        if ( N > 0)
        {

            for (int i = 1; i <= N; i++)
            {
                String number_s = reader.readLine();
                int number = Integer.parseInt(number_s);

                if (i == 1 || number > maximum)
                {
                    maximum = number;
                }
            }
        }




        System.out.println(maximum);
    }
}
/*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

int sum=0;

while (true)
        {
        String string1 = bufferedReader.readLine();
        int num1=Integer.parseInt(string1);
        if (num1==-1)
        {
        sum=sum+num1;
        System.out.println(sum);
        break;
        }
        sum=sum+num1;
        }*/