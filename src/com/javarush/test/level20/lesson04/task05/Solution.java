package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {

    public static void main(java.lang.String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial20_04_05")))
        {

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2


            System.out.println("---object before serialization---");
            System.out.print("object.string1 = ");
            object.string1.print();;
            System.out.print("object.string2 = ");
            object.string2.print();
            System.out.println("---object before serialization---");

            objOStrm.writeObject(object);

        }
        catch (IOException e)
        {
            System.out.println("исключение во время сериализации : " + e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial20_04_05")))
        {
            Object loadObject = (Object)objIStrm.readObject();

            System.out.println("---object after deserialization---");
            System.out.print("loadObject.string1 = ");
            loadObject.string1.print();;
            System.out.print("loadObject.string2 = ");
            loadObject.string2.print();
            System.out.println("---object before deserialization---");

        }
        catch (Exception e)
        {
            System.out.println("Исключение после десериализации : " + e);
            System.exit(0);
        }

    }

    public static class Object implements Serializable{
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
