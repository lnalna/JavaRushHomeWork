package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties props = new Properties();
        try
        {
        props.load(new FileInputStream(new File(reader.readLine())));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
        reader.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        for(Map.Entry<Object, Object> prop_temp:props.entrySet())
            properties.put(prop_temp.getKey().toString(),prop_temp.getValue().toString());

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);

        String isProperties = properties != null ? "yes":"no";

        printWriter.println(isProperties);

        if("yes".equals(isProperties))
        {
           for(Map.Entry<String,String> temp_prop:properties.entrySet())
               printWriter.println(temp_prop.getKey()+" = "+temp_prop.getValue());
        }

        printWriter.flush();
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String isProperties = reader.readLine();

        if("yes".equals(isProperties))
        {
            properties = new HashMap<String,String>();

            String temp="";
            while((temp=reader.readLine())!=null)
            {
                String[] temp_str=temp.split("=");

                properties.put(temp_str[0].trim(),temp_str[1].trim());
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
        File your_file_name = File.createTempFile("/tmp/task_20_02_03.txt", null);
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);

        Solution test = new Solution();
        test.fillInPropertiesMap();

         test.save(outputStream);
         outputStream.flush();

         Solution test2 = new Solution();
         test2.load(inputStream);

        outputStream.close();
        inputStream.close();

            for(Map.Entry<String,String> temp_prop:properties.entrySet())
               System.out.println(temp_prop.getKey() + " = " + temp_prop.getValue());

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
