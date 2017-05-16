package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        BufferedReader fileBufReader = new BufferedReader(fileReader);
       // BufferedWriter fileBufWriter = new BufferedWriter(fileWriter);

        String line="";
        String result="";
        while((line = fileBufReader.readLine()) != null)
        {
            Pattern pat = Pattern.compile("[^\\s]*\\d[^\\s]*");
            Matcher mat = pat.matcher(line);


            while(mat.find())
                result+=mat.group()+" ";


        }
        fileReader.close();

        fileBufReader.close();

        result=result.trim();

        fileWriter.write(result);
        fileWriter.flush();
        fileWriter.close();
        //fileBufWriter.close();
    }
}
