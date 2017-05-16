package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(path));
        String s = null;
        char[] temp_array;
        while ( (s = br.readLine())!=null)
        {
            temp_array=s.toCharArray();

            for(int i=temp_array.length-1;i>=0;i--)
                System.out.print(temp_array[i]);
            System.out.println();
        }
        br.close();
    }

}
