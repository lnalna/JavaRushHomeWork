package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        List<Integer> list_all_values = new ArrayList<Integer>();
        //читаем с консоли имя файла
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inp = new FileInputStream(r.readLine());


        // читаем все байты из файла в list_all_values
        while(inp.available() > 0)
        {
            int tmp = inp.read();
        //    System.out.print(tmp+" ");
            if(!list_all_values.contains(tmp))  list_all_values.add(tmp);
        }
        //System.out.println();

        int[] a = new int[list_all_values.size()];

        int i=0;
        for(Integer temp:list_all_values)
        {
            a[i]=temp;
            i++;
        }

        for(int j=0;j<a.length;j++)
          for(int k=0;k<a.length-1;k++)
            if(a[k+1]<a[k])
              {
                 int temp_var=a[k];
                  a[k]=a[k+1];
                  a[k+1]=temp_var;
              }

        for(int m=0;m<a.length;m++)
            System.out.print(a[m]+" ");

        r.close();
        inp.close();
    }
}

