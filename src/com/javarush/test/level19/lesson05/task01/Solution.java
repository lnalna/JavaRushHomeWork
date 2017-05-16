package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(ISR);
        String sFileName1="";
        String sFileName2="";

        try {
             sFileName1 = BR.readLine();
             sFileName2 = BR.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


            FileReader reader = new FileReader(sFileName1);
            FileWriter writer = new FileWriter(sFileName2);

            int i=0;
            while (reader.ready())
            {
                i++;
                int data = reader.read();

                if (i%2==0)
                {

                    writer.write(data);
                }

            }
        reader.close();
        writer.close();
    }
}
