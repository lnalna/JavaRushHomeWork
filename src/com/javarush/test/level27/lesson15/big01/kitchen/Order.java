package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 03.06.15.
 */
public class Order
{
    Tablet tablet;
    List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime()
    {
        int totalTime = 0;
        for (Dish dish : dishes)
        {
            totalTime += dish.getDuration();
        }
        return totalTime;
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    @Override
    public String toString()
    {
        if (dishes.isEmpty())
        {
            return "";
        }
        else
        {
            return "Your order: " + dishes + " of "+tablet;
        }
    }
}
