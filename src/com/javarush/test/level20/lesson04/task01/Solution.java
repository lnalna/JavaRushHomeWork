package com.javarush.test.level20.lesson04.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {

    public static void main(String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial")))
        {
            Human human1 = new Human("Human", new Asset("home"), new Asset("car"));
            objOStrm.writeObject(human1);
        }
        catch(IOException e)
        {
            System.out.println("Исключение во время сериализации: " + e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial")))
        {
            Human human2 = (Human)objIStrm.readObject();
        }
        catch(Exception e)
        {
            System.out.println("исключение во время сериалтзации: " + e);
            System.exit(0);
        }
    }

    public static class Human implements Serializable{
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }
}
