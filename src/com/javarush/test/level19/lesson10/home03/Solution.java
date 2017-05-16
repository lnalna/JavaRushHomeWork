package com.javarush.test.level19.lesson10.home03;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.io.*;
import java.util.Calendar;


/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{

        String line = "";
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"));
        Calendar birthdayCalendar = new GregorianCalendar();
        while((line = r.readLine())!= null)
        {
            String[] array = line.split(" ");
            String name = "";
            int date=0; int year=0; int month=0;

            for(int i =array.length-3;i<array.length;i++)
            {
               date = Integer.parseInt(array[i]);
               year = Integer.parseInt(array[i+2]);
               month = Integer.parseInt(array[i+1]);
               break;
            }

            for(int i=0;i<array.length-3;i++)
              name = name +" "+array[i];

            name=name.trim();
            birthdayCalendar.set(year,month-1,date);
            PEOPLE.add(new Person(name,birthdayCalendar.getTime()));
            }
            for(Person temp_Person:PEOPLE)
                System.out.println(temp_Person.getName()+" "+temp_Person.getBirthday());
        r.close();
        }

}


