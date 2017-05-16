package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string1=bufferedReader.readLine();
        String string2=bufferedReader.readLine();
        String string3=bufferedReader.readLine();

        int num1=Integer.parseInt(string1);
        int num2=Integer.parseInt(string2);
        int num3=Integer.parseInt(string3);

        if (num1 <= num2 && num2 <= num3){System.out.println(num2);}
        if (num1 <= num3 && num3 <= num2 ){System.out.println(num3);}
        if (num2 <= num1 && num1 <= num3){System.out.println(num1);}
        if (num2 <= num3 && num3 <= num1){System.out.println(num3);}
        if (num3 <= num2 && num2 <= num1){System.out.println(num2);}
        if (num3 <= num1 && num1 <= num2){System.out.println(num1);}

    }
}
