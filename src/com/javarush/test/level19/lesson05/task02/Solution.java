package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException{


        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(ISR);

        FileReader fin = new FileReader(BR.readLine());

        Scanner src = new Scanner(fin);
        String s="";

        while(src.hasNext())
            s+=src.nextLine()+"\r\n";
        src.close();

        //  String text    =
        //        "World world, This is the text to world be searched " +
        //              "for occurrences of world the http:// pattern world.";

        s=s.replaceAll("\\p{P}"," ").toLowerCase();

        String[] stroka  = s.split(" ");

        int world=0;

        for (int i=0;i<stroka.length;i++)
        {

            String patternString = ".*world.*";

            Pattern pattern = Pattern.compile(patternString);

            Matcher matcher = pattern.matcher(stroka[i]);
            boolean matches = matcher.matches();

            if (matches) world++;
            matches=false;
        }

        System.out.println(world);
    }
}
