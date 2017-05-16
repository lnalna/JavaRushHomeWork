package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by admin on 12.11.14.
 *
 * 2. Класс Plane должен иметь 1 конструктор с параметром int - количество перевозимых пассажиров.
 */
public class Plane implements Flyable
{
    private int passengers;

    public void fly()
    {

    }

    public Plane(int passengers)
    {
        this.passengers=passengers;
      //  System.out.println("Plane created");
    }
}
