package com.javarush.test.level26.lesson02.task01;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args)
    {

     //   Integer[] arr = new Integer[]{8,5,13,17,15};
       // Integer[] array1 = sort(arr);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] array1 = sort(arr);

        System.out.println("array1:");
        for(int i=0;i<array1.length;i++)
            System.out.print(array1[i]+" ");

     //   System.out.println();
     //   System.out.println();

      //  Integer[] arr2 = new Integer[]{15,17,5,8};
     //   Integer[] array2 = sort(arr2);

    //    System.out.println("array2:");
    //    for(int i=0;i<array2.length;i++)
    //        System.out.print(array2[i]+" ");
   //     System.out.println();

    }
    public static Integer[] sort(Integer[] array) {
        //implement logic here

        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<Integer>(array.length);
        Collections.addAll(list, array);


        if(list.size()%2!=0)//если число элементов списка нечетное, то медиана одна
        {
            final int  med=list.get(list.size()/2);
            list.remove(list.size()/2);
       //     System.out.println(med);

            Comparator<Integer>compareByMedian1 = new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    int result = (Math.abs(med-o1)-Math.abs(med-o2));

                    return result==0? o1-o2: (Math.abs(med-o1)-Math.abs(med-o2));
                }
            };

            Collections.sort(list,compareByMedian1);

            array[0]=med;

            for(int i=1;i<array.length;i++)
                array[i]=list.get(i-1);

        }else//если число элементов массива четное, то медиан две
        {
            final int med1=list.get(list.size()/2 - 1);
            final int med2=list.get(list.size()/2);
            list.remove(list.size()/2 - 1);
            list.remove(list.size()/2);
         //   System.out.println(med1);
         //   System.out.println(med2);

            Comparator<Integer>compareByMedian2 = new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    int result  = (Math.abs(med1-o1)+Math.abs(med2-o1))-(Math.abs(med1-o2)+Math.abs(med2-o2));
                    return result==0? o1-o2:(Math.abs(med1-o1)+Math.abs(med2-o1))-(Math.abs(med1-o2)+Math.abs(med2-o2));
                }
            };

            Collections.sort(list,compareByMedian2);

            array[0]=med1;
            array[1]=med2;

            for(int i=2;i<array.length;i++)
                array[i]=list.get(i-2);

        }
        return array;
    }
}
