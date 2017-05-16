package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        Map<Character, byte[]> map=new TreeMap<Character,byte[]>();


        String all_file="";
        while (true){
            String s=r.readLine();
            if(s.equals("end")){
                break;
            }
            FileInputStream fileInputStream=new FileInputStream(s);

            byte []b=new byte[fileInputStream.available()];
            int a=fileInputStream.read(b);
            String s1[]=s.split("\\.");

            all_file=s1[0]+"."+s1[1];
            map.put(s1[s1.length-1].charAt(s1[s1.length-1].length()-1),b);

            //s1[s1.length-1] - последний элемент в массиве s1, т.е. partN
            //charAt(s1[s1.length-1].length()-1   - возвращает последний символ из partN, т.е. N
            //т.е. будет возвращаться только один!!! символ, от двузначного числа вернется только одна цифра!!!
            fileInputStream.close();
        }

        OutputStream outStream = null;

        outStream = new FileOutputStream(all_file);
        outStream = new BufferedOutputStream(outStream);
        for (Map.Entry<Character, byte[]> characterEntry : map.entrySet())
        {

            outStream.write(characterEntry.getValue());
            outStream.flush();
        }
        outStream.close();
        r.close();
    }

}


