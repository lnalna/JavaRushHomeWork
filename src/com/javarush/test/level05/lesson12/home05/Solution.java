package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;

        while (true)
        {
            String string1 = bufferedReader.readLine();
            if (string1.equals("сумма"))
            {
                break;
            }
            int num1=Integer.parseInt(string1);
         //   if (num1==-1)
           // {
             //   sum=sum+num1;
               // System.out.println(sum);
                //break;
            //}
            sum=sum+num1;
        }

        System.out.println(sum);
    }
}
