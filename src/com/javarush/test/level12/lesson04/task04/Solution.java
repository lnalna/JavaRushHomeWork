package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {
      /*  int a=10,b=2;

        System.out.println(min(a,b));

        long c=10,d=2;
        System.out.println(min(c,d));

        double e=10,f=2;
        System.out.println(min(e,f));
*/
    }

    //Напишите тут ваши методы
    public static int min(int a,int b)
    {
        if (a<b)
        {
        //    System.out.println();
          //  System.out.println("int method");
            return a;
        }
        {
            //System.out.println();
            //System.out.println("int method");
            return b;
        }
    }
    public static long min(long a,long b)
    {
        if (a<b)
        {
            //System.out.println();
            //System.out.println("long method");
            return a;
        }
        {
            //System.out.println();
            //System.out.println("long method");
            return b;
        }
    }
    public static double min(double a,double b)
    {
        if (a<b)
        {
            //System.out.println();
            //System.out.println("double method");
            return a;
        }
        {
            //System.out.println();
            //System.out.println("double method");
            return b;
        }
    }
}
