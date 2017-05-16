package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>,
где первый параметр – уникальная строка, а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //Напишите тут ваш код
        for(int i=0;i<list.size();i++)
           result.put(list.get(i),0);

            for(String temp:list)
            {

                for (Map.Entry<String, Integer> s : result.entrySet())
                {
                    if (s.getKey().equals(temp))
                    {
                        int temp_int = 0;
                        temp_int = s.getValue();
                        temp_int++;
                        result.put(s.getKey(), temp_int);
                    }
                }
            }



        return result;
    }

}
