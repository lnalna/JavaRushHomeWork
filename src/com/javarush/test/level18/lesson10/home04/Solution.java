package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file1 = new File(reader.readLine());//считаем с консоли имя первого файла
        File file2 = new File(reader.readLine());//считаем с консоли имя второго файла

        FileInputStream in1 = new FileInputStream(file1);//открываем первый на чтение
        FileInputStream in2 = new FileInputStream(file2);//открываем второй на чтение

        byte[] data1 = new byte[0];
        byte[] data2 = new byte[0];

// читаем из второго файла в массив data2
        while(in2.available() > 0){
            data2 = new byte[in2.available()];
            int count = in2.read(data2);
        }

        //читаем из первого файла в массив data1
        while(in1.available() > 0){
            data1 = new byte[in1.available()];
            int count = in1.read(data1);
        }

        in1.close();
        in2.close();

        FileOutputStream out1 = new FileOutputStream(file1);

        byte[] result = new byte[data1.length + data2.length];

        System.arraycopy(data2, 0, result, 0, data2.length);

        System.arraycopy(data1, 0, result, data2.length, data1.length);

        out1.write(result); // запись в файл


        reader.close();
        out1.close();

    }
}

