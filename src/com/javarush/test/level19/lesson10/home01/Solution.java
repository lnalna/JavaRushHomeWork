package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)throws IOException {

        if(args.length == 0) throw new IllegalArgumentException();

     //   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
//        reader.close();
        fileBufReader.close();

        for(Map.Entry<String,Double> map_temp :map.entrySet())
        {
            System.out.println(map_temp.getKey() + " " + map_temp.getValue());
        }
    }
}

