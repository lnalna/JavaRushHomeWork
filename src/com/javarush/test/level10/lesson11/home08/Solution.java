package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.Collections;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //Напишите тут ваш код
        ArrayList<String>[] arrayOfStringList = new ArrayList[3];
        arrayOfStringList[0]=new ArrayList<String>();
        arrayOfStringList[1]=new ArrayList<String>();
        arrayOfStringList[2]=new ArrayList<String>();
        Collections.addAll(arrayOfStringList[0],"abc");
        Collections.addAll(arrayOfStringList[1],"def");
        Collections.addAll(arrayOfStringList[2],"ghi");

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}