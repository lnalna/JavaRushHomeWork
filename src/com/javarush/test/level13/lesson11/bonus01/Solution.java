package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Scanner sc = new Scanner(new File(reader.readLine()));

        ArrayList<Integer> list = new ArrayList<Integer>();
        while(sc.hasNext())
        {
            list.add(sc.nextInt());
        }

        int temp=0;
        for(int j=0;j<list.size();j++)
            for(int i=1;i<list.size();i++)
            {
                if(list.get(i)<list.get(i-1))
                {
                    temp=list.get(i);
                    list.set(i,list.get(i-1));
                    list.set(i-1,temp);
                }
            }

        for(Integer number: list)

        if(number%2==0) System.out.println(number);
    }
}
