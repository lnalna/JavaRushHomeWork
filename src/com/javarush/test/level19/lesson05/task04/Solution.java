package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Solution {
    public static void main(String[] args) throws IOException {

        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(ISR);
        String filename1=BR.readLine();
        String filename2=BR.readLine();

        BR.close();
        ISR.close();

        FileReader fin = new FileReader(filename1);
        FileWriter writer =new FileWriter(new File(filename2));


        Scanner src = new Scanner(fin);
        String s="";

        while(src.hasNext())
            s+=src.nextLine()+"\r\n";
        src.close();
        fin.close();

        Pattern pat = Pattern.compile("(\\.)");// Pattern pat = Pattern.compile("([^a-z](\\d+)[^a-z])");
        Matcher mat = pat.matcher(s);


        String all_string="";

        while(mat.find())//пока числа встречаются при анализе строки, пишем их в файл fout
        {
            all_string+=mat.replaceAll("!");

        }
        all_string=all_string.replaceAll("\\r","");
        all_string=all_string.trim();
        //   System.out.println(all_string);
        writer.write(all_string);
        //  writer.flush();
        writer.close();

    }
}
