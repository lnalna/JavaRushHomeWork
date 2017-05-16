package com.javarush.test.level15.lesson12.home04;

/**
 * Created by admin on 10.11.14.
 */
class Sun implements Planet
{
    private static Sun instance;
    private Sun() {}
    public static Sun getInstance()
    {
        if(instance == null)
        {
            instance = new Sun();
        }
        return instance;
    }
}
