package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial20_10_03")))
        {
           Solution solution = new Solution();
           Solution.B b = solution.new B("bName");

            System.out.println(b.name);
            objOStrm.writeObject(b);
        }
        catch (IOException e)
        {
            System.out.println("Error  during in serialization "+e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial20_10_03")))
        {
     //       Solution solution2 = new Solution();
           B loadB=(B)objIStrm.readObject();
            System.out.println(loadB.name);
        }
        catch (Exception e)
        {
            System.out.println("Error during deserialization "+e);
        }

    }

    public static class A {

        protected String name = "A";

        public A(){ }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {

        private static final long serialVersionUID = 1L;


          public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            String n = (String) in.readObject();
            name = n;
        }

    }
}
