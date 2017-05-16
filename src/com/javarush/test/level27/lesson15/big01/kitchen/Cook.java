package com.javarush.test.level27.lesson15.big01.kitchen;


import java.util.Observable;
import java.util.Observer;
import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;



/**
 * Created by admin on 05.06.15.
 */
public class Cook extends Observable implements Observer
{
    public String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable tablet, Object order)
    {
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order.toString(),
                ((Order) order).getTotalCookingTime()));

        CookedOrderEventDataRow event = new CookedOrderEventDataRow(tablet.toString(), this.name, ((Order) order).getTotalCookingTime() * 60, ((Order) order).getDishes());
        StatisticManager.getInstance().register(event);

        setChanged();
        notifyObservers(order);
    }

}
