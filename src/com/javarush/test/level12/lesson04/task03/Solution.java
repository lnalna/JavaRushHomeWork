package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {
/*
        Integer x=2;
        print(x);

        int y=3;
        print(y);

        String test_string="test string";
        print(test_string);

        char my_char='a';
        print(my_char);

        long my_long=2222222;
        print(my_long);*/
    }
    //Напишите тут ваши методы
    public static void print(int n)
    {
        System.out.println("method int  "+n);
        System.out.println();
    }
    public static void print(Integer m)
    {
        System.out.println("method Integer  "+m);
        System.out.println();
    }
    public static void print(String stroka)
    {
        System.out.println("method String  "+stroka);
        System.out.println();
    }
    public static void print(char a)
    {
        System.out.println("method char  "+a);
        System.out.println();
    }
    public static void print(long b)
    {
        System.out.println("method long "+b);
        System.out.println();
    }
}
