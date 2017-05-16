package com.javarush.test.level14.lesson08.home09;

/**
 * Created by nik on 03.11.14.
 */
public class Hrivna extends Money
{

    public Hrivna(double amount)
    {
        super(amount);
    }
    public String getCurrencyName()
    {
        return "HRN";
    }
}
