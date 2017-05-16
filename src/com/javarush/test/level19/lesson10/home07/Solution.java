package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{

        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        BufferedReader fileBufReader = new BufferedReader(fileReader);
        // BufferedWriter fileBufWriter = new BufferedWriter(fileWriter);

        String line="";
        String[] result;
        int count_comma=0;
        while((line = fileBufReader.readLine()) != null)
        {
           //line=line.replaceAll("\n\r"," ");
            result = line.split(" ");


            for(int i=0;i<result.length;i++)
            {
                result[i]=result[i].trim();

                if((result[i].length()>6)&&(count_comma==0))
                {
                    fileWriter.write(result[i]);
                    fileWriter.flush();
                    count_comma++;
                }
                else  if((result[i].length()>6)&&(count_comma!=0))
                {
                    fileWriter.write(","+result[i]);
                    fileWriter.flush();
                    count_comma++;
                }


            }

        }





        fileReader.close();

        fileBufReader.close();


       // fileWriter.write(result);
        //fileWriter.flush();
        fileWriter.close();
        //fileBufWriter.close();

    }
}
