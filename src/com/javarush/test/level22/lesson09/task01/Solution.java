package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();


    public static void main(String[] args) throws Exception{

        String[] tmp_result ;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());

        BufferedReader fileBufReader = new BufferedReader(fileReader);

        String temp_str;

        while((temp_str = fileBufReader.readLine()) != null)
        {
            tmp_result = temp_str.split(" ");

            for(int i=0;i<tmp_result.length-1;i++)
                for(int j=i+1;j<tmp_result.length;j++)
                {
                    String tmp = tmp_result[j];
                    StringBuilder s = new StringBuilder(tmp);
                    tmp=s.reverse().toString();
                    if(tmp_result[i].equals(tmp))
                        result.add(new Pair(tmp_result[i],tmp_result[j]));
                }
        }
        reader.close();
        fileBufReader.close();


        for(Pair temp_pair:result)
        {
            System.out.println(temp_pair.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first,String second)
        {
            this.first=first;
            this.second=second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
