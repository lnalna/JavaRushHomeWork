package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/C:/tmp/serial20_10_05")))
        {
            SubSolution subSolution = new SubSolution();
            objOStrm.writeObject(subSolution);

        }catch (IOException e)
        {
            System.out.println("Error  during in serialization "+e);
        }

    }
    public static class SubSolution extends Solution {

        private static final long serialVersionUID = 1L;

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException
        {
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream objectInputStream) throws IOException,ClassNotFoundException
        {
            throw new NotSerializableException();
        }
    }
}
