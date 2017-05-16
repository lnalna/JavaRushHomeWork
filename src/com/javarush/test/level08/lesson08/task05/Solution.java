package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Sim");
        map.put("Baby", "Sim");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");
     return (HashMap<String, String>) map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list_double = new ArrayList<String>();

        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String,String > pair = iterator.next();
            list.add(pair.getValue());
        }

        for(int i=0;i<list.size()-1;i++)
        {
            for (int j = i+1; j < list.size(); j++)
            {
                if (list.get(i).equals(list.get(j)))
                {

                    list_double.add(list.get(i));
                }
            }
        }

        int b=list.size();

        for (int k=0;k<b;k++)
        {
            for (int i = 0; i < list_double.size(); i++)
            {
                String a = list_double.get(i);

                while(iterator.hasNext())
                {
                    Map.Entry<String,String > pair = iterator.next();
                    if (a.equals((pair.getValue())))
                        iterator.remove();
                }


            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
