package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;

public class Solution {

    public static void main(String[] args) throws IOException
    {

        if(args.length == 0) throw new IllegalArgumentException();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());

        BufferedReader fileBufReader = new BufferedReader(fileReader);

        String result;

        while((result = fileBufReader.readLine()) != null)
        {
            if(result.startsWith(args[0] + " "))
            {
                System.out.println(result);
                break;
            }
        }
        reader.close();
        fileBufReader.close();
    }
}