package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        //...

        String[] tmp_result1 ;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader fileBufReader = new BufferedReader(fileReader);
        String temp_str;

        while((temp_str = fileBufReader.readLine()) != null)
        {

            tmp_result1 = temp_str.split(" ");
            StringBuilder result = getLine(tmp_result1);

            System.out.println(result.toString());
        }
    }

    public static StringBuilder getLine(String... words) {

        if(words.length==0)
        {
            StringBuilder sb = new StringBuilder("");
            return sb;
        }

        if(words.length==1)
        {
            StringBuilder sb = new StringBuilder(words[0]);
            return sb;
        }

        String symbol1,symbol2;
        boolean flag = false;

        while (!flag)
        {
            Random rnd = new Random();
            for(int r=words.length-1;r>0;r--)
            {
                int index = rnd.nextInt(r+1);
                String a = words[index];
                words[index]=words[r];
                words[r]=a;
            }

            int count=0;
            for(int k=0;k<words.length-1;k++)
            {
                symbol1 = words[k].substring(words[k].length() - 1).toUpperCase();
                symbol2 = words[k + 1].substring(0, 1).toUpperCase();

                if(symbol1.equals(symbol2))
                {
                    count++;
                    if(count==words.length-1)
                    {
                        flag = true;
                        break;
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<words.length;i++)
        {
            if(i<words.length-1)
            {
            sb.append(words[i]+" ");
            }
            else
            {
                sb.append(words[i]);
            }
        }

        return sb;
    }
}
