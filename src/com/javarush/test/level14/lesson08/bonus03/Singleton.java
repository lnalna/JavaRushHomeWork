package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by admin on 05.11.14.
 */
public class Singleton
{

    private Singleton()
    {

    }
    private static final Singleton INSTANCE = new Singleton();

    public static final Singleton getInstance()
    {
        return INSTANCE;
    }
}