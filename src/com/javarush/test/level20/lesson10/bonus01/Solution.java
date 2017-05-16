package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;


/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    public static void main(String[] args)
    {
        long t0= System.currentTimeMillis();
     //   long n = (long) Math.pow(10,8);

        long memoryStart = Runtime.getRuntime().freeMemory();
        int[] numbers = getNumbers(100_000);
        long memoryEnd = Runtime.getRuntime().freeMemory();

        long memoryTaken = (memoryStart - memoryEnd)/(1024*1024);//получаем байты

        System.out.println("Memory = "+memoryTaken);

        long t1 = System.currentTimeMillis();
        System.out.println("time: "+(t1-t0)/1000d+ "sec");

        for(int i=0;i<numbers.length;i++)
            System.out.println(numbers[i]);
    }

   public static int mypow(int a,int n)
    {
        if (n==0) return 1;
        if (n%2==1) return mypow(a,n-1)*a;
        else{
            int b = mypow(a,n/2);
            return b*b;
        }

    }

    public static int[] getNumbers(int N)
    {
        int[] result = null;



        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < N; i++)
        {
            byte degree = 0;
            int input = i;
            int number=i;
            do
            {
                degree++;
            }while((i/=10)>0);


            int sum = 0;
            int k;

            do
            {
                k=input%10;
               // sum +=Math.pow(k,degree);
                sum+=mypow(k,degree);
            }while((input/=10)>0);

            if(sum==number) list.add(number);

            i=number;
            }

        result = new int[list.size()];

        for(int j=0;j<list.size();j++)
            result[j]=list.get(j);

        return result;
    }
}
