package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        //Напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();

        map.put("арбуз","ягодов");
        map.put("арбуз","травов");
        map.put("вишня","ягодов");
        map.put("груша","фруктов");
        map.put("дыня","овощев");
        map.put("ежевика","кустов");
        map.put("жень-шень","коренев");
        map.put("земляника","ягодов");
        map.put("ирис","цветоков");
        map.put("картофель","цветоков");

        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
