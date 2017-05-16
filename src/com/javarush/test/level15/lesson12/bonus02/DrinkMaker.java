package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by admin on 12.11.14.
 */
public abstract class DrinkMaker
{
  public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    void makeDrink()
    {
         getRightCup();
         putIngredient();
         pour();
    }
}
