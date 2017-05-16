package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static void main(String[] args)
    {
        String query="level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01." +
                "level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01." +
                "level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01." +
                "level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01." +
                "level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01." +
                "level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01." +
                "level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01." +
                "level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.level22.lesson13.task01.";
        String delimiter=".";

        String[] arr;

        arr=getTokens(query,delimiter);

        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);

    }

    public static String [] getTokens(String query, String delimiter) {

        ArrayList<String> str = new ArrayList<String>();

        try
        {
            StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

            while(tokenizer.hasMoreTokens())
            {
               str.add(tokenizer.nextToken());
            }

        } catch (NullPointerException e)
        {
            System.out.println("data is null!!!");
        }

        String[] result_arr = new String[str.size()];

        for(int i=0;i<str.size();i++)
            result_arr[i]=str.get(i);

        return result_arr;

    }
}
