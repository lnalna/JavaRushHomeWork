package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream in1 = new FileInputStream(new File(reader.readLine()));
        FileOutputStream out2 = new FileOutputStream(new File(reader.readLine()));


        while(in1.available() > 0)
        {

          byte[] normal_arr = new byte[in1.available()];
          byte[] reverse_arr = new byte[in1.available()];
          int count = in1.read(normal_arr);

          int j=0;
          for(int i=normal_arr.length-1;i>=0;i--)
          {
            reverse_arr[j] = normal_arr[i];
            j++;
          }

        out2.write(reverse_arr, 0, count);

        }
        reader.close();
        in1.close();
        out2.close();
    }
}
