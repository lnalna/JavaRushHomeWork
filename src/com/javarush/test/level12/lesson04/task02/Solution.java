package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Integer x=2;
        print(x);

        int y=3;
        print(y);
    }

    //Напишите тут ваши методы

    public static void print(int n)
    {
        //System.out.println(n);
        System.out.println("method int  "+n);
        System.out.println();
    }

    public static void print(Integer m)
    {
        //System.out.println(m);
        System.out.println("method Integer  "+m);
        System.out.println();

    }
}
