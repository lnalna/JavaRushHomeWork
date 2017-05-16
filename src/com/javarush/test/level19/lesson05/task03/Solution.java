package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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

       Pattern pat = Pattern.compile("(\\b)[0-9]+(\\s|\\b)");// Pattern pat = Pattern.compile("([^a-z](\\d+)[^a-z])");
        Matcher mat = pat.matcher(s);


        String all_string="";

       while(mat.find())//пока числа встречаются при анализе строки, пишем их в файл fout
        {
            all_string+=mat.group()+" ";

        }
            all_string=all_string.replaceAll("\\r","");
            all_string=all_string.trim();
   //   System.out.println(all_string);
            writer.write(all_string);
      //  writer.flush();
            writer.close();

    }
}
