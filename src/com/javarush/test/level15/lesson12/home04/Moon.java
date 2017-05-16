package com.javarush.test.level15.lesson12.home04;

/**
 * Created by admin on 10.11.14.
 */
class Moon implements Planet
{
    private static Moon instance;
    private Moon() {}
    public static Moon getInstance()
    {
        if(instance == null)
        {
            instance = new Moon();
        }
        return instance;
    }
}