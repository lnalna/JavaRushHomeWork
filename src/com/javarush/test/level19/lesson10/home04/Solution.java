package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{

        String line = "";
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file_name=r.readLine();//читаем имя файла с консоли

        FileReader fileReader = new FileReader(file_name);
        BufferedReader fileBufReader = new BufferedReader(fileReader);

        while((line = fileBufReader.readLine()) != null)
        {
            String[] array = line.split(" ");

            int words_count=0;

            for(int i=0;i<array.length;i++)
            {
                if (words.contains(array[i]))
                    words_count++;

                if ((words_count==2)&(i==array.length-1))
                {

                    for(int j=0;j<array.length;j++)

                        if (j<(array.length-1))
                          System.out.print(array[j]+" ");
                        else
                            System.out.println(array[j]);
                }

            }
        }
        r.close();
        fileBufReader.close();
        fileReader.close();

    }
}
