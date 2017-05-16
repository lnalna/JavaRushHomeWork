package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.TreeMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args.length==0) throw new IllegalArgumentException();

        FileInputStream in = new FileInputStream(new File(args[0]));

        TreeMap<Character,Integer> map = new TreeMap<Character, Integer>();

        char[] symbols = new char[0];

        while(in.available()>0)
        {
            byte[] data = new byte[in.available()];
            in.read(data);
            symbols = new String(data).toCharArray();
        }
        in.close();

        for(char ch: symbols)
        {
            if(map.containsKey(ch))
            {
                int temp = map.get(ch)+1;
                map.put(ch,temp);
            } else
            {
                map.put(ch,1);
            }

        }

        for(Map.Entry<Character,Integer> ch_temp :map.entrySet())
        {
            System.out.println(ch_temp.getKey()+" "+ch_temp.getValue());
        }

 }
}

