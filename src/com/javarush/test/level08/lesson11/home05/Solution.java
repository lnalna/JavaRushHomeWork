package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] myCharArray = s.toCharArray();
        String[] myStringArray = new String[myCharArray.length];

        for(int i=0;i<myCharArray.length;i++)
        {
            myStringArray[i]=String.valueOf(myCharArray[i]);
        }


        if (myStringArray[0]!=" ")
        {
            myStringArray[0]=myStringArray[0].toUpperCase();
        }

        for(int i=1;i<myStringArray.length;i++)
        {
            if(myStringArray[i-1].equals(" "))
            {
                if (myStringArray[i]!=" ")
                {
                    myStringArray[i] = myStringArray[i].toUpperCase();
                }
            }
        }

        String resultString="";
        for(int i=0;i<myStringArray.length;i++)
        {
            resultString+=myStringArray[i];
        }

        System.out.println(resultString);


    }



}
