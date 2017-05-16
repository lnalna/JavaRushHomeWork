package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)throws IOException{

        if(args.length == 0) throw new IllegalArgumentException();

        FileReader fileReader = new FileReader(args[0]);

        BufferedReader fileBufReader = new BufferedReader(fileReader);

        String result;

        TreeMap<String,Double> map = new TreeMap<String,Double>();

        while((result = fileBufReader.readLine()) != null)
        {
            String[] temp_data=result.split(" ");

            temp_data[0].trim();temp_data[1].trim();
            if (map.containsKey(temp_data[0]))
            {
                double temp_value= map.get(temp_data[0]);
                temp_value+=Double.parseDouble(temp_data[1]);
                map.put(temp_data[0],temp_value);
            }
            else
            {
                map.put(temp_data[0],Double.parseDouble(temp_data[1]));
            }
        }
        fileReader.close();
        fileBufReader.close();

        double max_value=0.0;
        for(Map.Entry<String,Double> map_temp :map.entrySet())
        {
            if (map_temp.getValue()>max_value) max_value=map_temp.getValue();
        }

        String max_name_all="";
        for(Map.Entry<String,Double> map_temp :map.entrySet())
        {
            if ( max_value==map_temp.getValue()) max_name_all+=map_temp.getKey()+" ";
        }
        System.out.println(max_name_all.trim());
    }
}

