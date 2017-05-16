package com.javarush.test.level26.lesson02.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {

    int height;
    int length;
    int width;

    public Solution(int height,int length,int width)
    {
        this.height=height;
        this.length=length;
        this.width=width;
    }

   public  String toString(){ return "height="+height+" length= "+length+" width= "+width;};


    public static void main(String[] args)
    {
        ArrayList<Solution> solution = new ArrayList<Solution>();
        solution.add(new Solution(9,8,10));
        solution.add(new Solution(8,7,9));
        solution.add(new Solution(7,8,9));

        Comparator<Solution>compareByHeight = new Comparator<Solution>()
        {
            @Override
            public int compare(Solution o1, Solution o2)
            {
                return o1.height-o2.height;
            }
        };

        Comparator<Solution>compareByLength = new Comparator<Solution>()
        {
            @Override
            public int compare(Solution o1, Solution o2)
            {
                return o1.length-o2.length;
            }
        };
        Comparator<Solution>compareByWidth = new Comparator<Solution>()
        {
            @Override
            public int compare(Solution o1, Solution o2)
            {
                return o1.width-o2.width;
            }
        };


        CustomizedComparator customizedComparator = new CustomizedComparator(compareByWidth,compareByLength,compareByHeight);
        Collections.sort(solution,customizedComparator);

        System.out.println(solution.toString());

    }

    public static class CustomizedComparator<T>implements Comparator<T>
    {
        ArrayList<Comparator<T>> comparators;

        public CustomizedComparator(Comparator<T>... comparators)
        {
            this.comparators = new ArrayList<>(comparators.length);
            Collections.addAll(this.comparators,comparators);
        }

        @Override
        public int compare(T o1, T o2)
        {
            int result = 0;

            for(int i=0;i<comparators.size();i++)
            {
                result = this.comparators.get(i).compare(o1,o2);

                if (result!=0) break;
            }
            return result;
        }
    }
}
