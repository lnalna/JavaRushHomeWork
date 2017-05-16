package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outStream = new FileOutputStream(reader.readLine());

    // new byte;
        ArrayList<String>list = new ArrayList<String>();
        while (true)
        {
            String stroka = reader.readLine();
            if (stroka.equals("exit"))
            {
                list.add(stroka);
                break;
            }
            stroka+="\r\n";

            list.add(stroka);

            //outStream.write(stroka.getBytes());
           // outStream.write(Integer.parseInt("\n"));
        }

        for(String temp_string : list)
        {
            outStream.write(temp_string.getBytes());
        }

        outStream.close();
    }
}
