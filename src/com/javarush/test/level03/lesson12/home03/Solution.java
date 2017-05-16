package com.javarush.test.level03.lesson12.home03;

/* Я буду зарабатывать $50 в час
Ввести с клавиатуры число n.
Вывести на экран надпись «Я буду зарабатывать $n в час».
Пример:
Я буду зарабатывать $50 в час
*/
import java.io.Reader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{

    public static void main(String[] args)   throws Exception
    {
        InputStream inputStream=System.in;//Напишите тут ваш код
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String s_money=bufferedReader.readLine();
        int n_money=Integer.parseInt(s_money);

        System.out.println("Я буду зарабатывать $"+n_money+" в час");
    }
}