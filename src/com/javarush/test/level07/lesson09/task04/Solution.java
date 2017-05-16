package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

/*while (true)
{
  String s = bis.readLine();
    if(s.isEmpty())  break;
    list.add(s);

}*/
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
       // list.add("аваол");
        //list.add("втавлсв");
        list.add("ваов");
        //list.add("ваолр");
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list)
    {
        //add your code here -  добавь код тут
        String str1="р";
        String str2="л";

        ArrayList<String> list2 = new ArrayList<String>();

        for (int i=0;i<list.size(); )
        {

            if ((list.get(i).contains(str1))&&!(list.get(i).contains(str2)))
            {
                list.remove(i);
            }
            else if ((list.get(i).contains(str2))&&!(list.get(i).contains(str1)))
            {
                list2.add(list.get(i));
                list2.add(list.get(i));
                i++;
                //continue;
            }

            else if ((list.get(i).contains(str1))&&(list.get(i).contains(str2)))
            {
                    list2.add(list.get(i));
                    i++;
                   // continue;
            }
             //   continue;

            else
            {
                list2.add(list.get(i));
                i++;
            }
        }


        return  list2;
    }
}