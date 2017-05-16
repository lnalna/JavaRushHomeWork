package com.javarush.test.level20.lesson04.task03;

import java.io.Serializable;
import java.io.*;

/* Как сериализовать Singleton?
Два десериализованных объекта singleton и singleton1 имеют разные ссылки в памяти, а должны иметь одинаковые.
В класс Singleton добавьте один метод (погуглите), чтобы после десериализации ссылки на объекты были равны.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Serializing the singleton instance
     try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/singleton.tmp")))
     {

        Singleton instance = Singleton.getInstance();
        oos.writeObject(instance);

     }
        catch (IOException e)
        {
            System.out.println("Ошибка сериализации : " + e);
        }


        //Recreating the instance by reading the serialized object data store
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/singleton.tmp")))
        {
        Singleton singleton = (Singleton) ois.readObject();

        System.out.println("Instance reference check : " + singleton.getInstance());
        System.out.println("Object reference check : " + singleton);


        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //Recreating the instance AGAIN by reading the serialized object data store
        try(ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("/tmp/singleton.tmp")))
        {
        Singleton singleton1 = (Singleton) ois2.readObject();

        System.out.println("Instance reference check : " + singleton1.getInstance());
        System.out.println("Object reference check : " + singleton1);


        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //The singleton behavior have been broken


        System.out.println("=========================================================");


    }

    public static class Singleton implements Serializable {
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }
        protected Object readResolve() {
            return getInstance();
        }

    }
}
