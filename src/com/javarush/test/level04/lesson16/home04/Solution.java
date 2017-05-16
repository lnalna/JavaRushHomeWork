package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s_name = bufferedReader.readLine();

        String s_year=bufferedReader.readLine();
        String s_month=bufferedReader.readLine();
        String s_day=bufferedReader.readLine();

        int n_year=Integer.parseInt(s_year);
        int n_month=Integer.parseInt(s_month);
        int n_day=Integer.parseInt(s_day);

        System.out.println("Меня зовут "+s_name);
        System.out.println("Я родился "+n_day+"."+n_month+"."+n_year);
    }
}
