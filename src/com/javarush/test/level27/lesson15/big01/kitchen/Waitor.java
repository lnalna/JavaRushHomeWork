package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Observable;
import java.util.Observer;
import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

/**
 * Created by admin on 05.06.15.
 */
public class Waitor implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        ConsoleHelper.writeMessage(String.format("%s  was cooked by %s", arg, o));
    }
}
