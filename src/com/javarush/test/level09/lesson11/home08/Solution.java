package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //Написать тут ваш код
        ArrayList main_list = new ArrayList<int[]>();
        int[] data1 = {1,2,3,4,5};
        int[] data2 = {6,7};
        int[] data3 = {8,9,10,11};
        int[] data4 = {12,13,14,15,16,17,18};
        int[] data5 ={};



      Collections.addAll(main_list, data1);
      Collections.addAll(main_list, data2);
      Collections.addAll(main_list, data3);
      Collections.addAll(main_list, data4);
      Collections.addAll(main_list, data5);

        return main_list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
