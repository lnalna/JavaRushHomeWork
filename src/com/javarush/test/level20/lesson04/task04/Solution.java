package com.javarush.test.level20.lesson04.task04;

import java.io.*;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {

    public static void main(String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial20_04_04")))
        {
            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;

            System.out.println("--classWithStatic before serialization---");
            System.out.println("ClassWithStatic staticString = "+ClassWithStatic.staticString);
            System.out.println("classWithStatic i = "+classWithStatic.i);
            System.out.println("classWithStatic j = "+classWithStatic.j);
            System.out.println("--classWithStatic before serialization---");

            objOStrm.writeObject(classWithStatic);

        }
        catch (IOException e)
        {
            System.out.println("Исключение во время сериализации : " + e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial20_04_04")))
        {
            ClassWithStatic loadClassWithStatic = (ClassWithStatic)objIStrm.readObject();

            System.out.println("---loadClassWithStatic---");
            System.out.println("loadClassWithStatic staticString = "+ClassWithStatic.staticString);
            System.out.println("loadClassWithStatic i = "+loadClassWithStatic.i);
            System.out.println("loadClassWithStatic j = "+loadClassWithStatic.j);
            System.out.println("---loadClassWithStatic---");

        }
        catch (Exception e)
        {
            System.out.println("Исключение во время сериализации : " + e);
            System.exit(0);
        }

    }

    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }
}
