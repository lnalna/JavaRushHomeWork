package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть все потоки ввода-вывода
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            FileInputStream in1 = new FileInputStream(new File(reader.readLine()));
            int count=in1.available();
        if (count<1000)
        {
            reader.close();
            in1.close();
            throw new DownloadException();
        }

            in1.close();
        }

    }

    public static class DownloadException extends Exception{

    }
}
