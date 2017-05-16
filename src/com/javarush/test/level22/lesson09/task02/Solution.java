package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args) throws Exception
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);


        StringBuilder s = getCondition(map);

        System.out.println(s);


        /*for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);

        }
        */

    }

    public static StringBuilder getCondition(Map<String, String> params) {

        int count=0; StringBuilder result_string= new StringBuilder("");
        for (Map.Entry<String, String> pair : params.entrySet())
        {
            if ((pair.getKey()!=null)&&(pair.getValue()!=null))
            {
                count++;
                if(count==1)
                {
                    result_string.append(pair.getKey()+" = "+"'"+pair.getValue()+"'");
                }
                else
                {
                    result_string.append(" and "+pair.getKey()+" = "+"'"+pair.getValue()+"'");
                }
            }

        }
        return result_string;
    }
}
