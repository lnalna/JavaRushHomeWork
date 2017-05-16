package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here - напиши код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month_name = reader.readLine();

        Date TestDate =  new Date();
        String testString=month_name+" "+TestDate.getDay()+" "+TestDate.getYear();
        Date TestDate2 =  new Date(testString);

        System.out.println(month_name+" is "+(TestDate2.getMonth()+1)+" month");

    }

}
