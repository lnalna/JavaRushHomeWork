package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Map<Integer,Integer> map =new HashMap<Integer,Integer>();
        List<Integer> list_max_values = new ArrayList<Integer>();

         //читаем с консоли имя файла
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inp = new FileInputStream(r.readLine());


        // читаем все байты из файла в map
        while(inp.available() > 0)
        {
            int tmp = inp.read();

            if (!map.containsKey(tmp))
            {
                map.put(tmp, 1);
            }
            else
            {
                for (Map.Entry<Integer, Integer> s : map.entrySet())
                {
                 //   System.out.println(tmp);
                    if (s.getKey().equals(tmp))// если такой байт в качестве ключа уже есть в map
                    // то читаем из value и увеличив value, пишем его обратно.
                    {
                        int tmp2= s.getValue();
                        tmp2++;
                        s.setValue(tmp2);
                    }
                }
            }
        }// while

        int max=0;
        for (Map.Entry<Integer, Integer> s : map.entrySet())
        {
            //   System.out.println(tmp);
            if (s.getValue()>max) max=s.getValue();
        }

      //  System.out.println("максимальное количество "+max);

        for (Map.Entry<Integer, Integer> s : map.entrySet())
        {
            //   System.out.println(tmp);
            if (s.getValue()==max) list_max_values.add(s.getKey());
        }

        for(Integer var_int:list_max_values)
            System.out.print(var_int+" ");
//        for(Map.Entry<Integer,Integer> s2 : map.entrySet())
  //      {
    //        System.out.print(s2.getKey()+" "+s2.getValue());
      //      System.out.println();
        //}
        r.close();
        inp.close();
    }//main
}//Solution

