package com.javarush.test.level15.lesson12.home04;

/* Закрепляем Singleton pattern
1. Найти в гугле пример для - Singleton pattern Lazy initialization.

Ленивая инициализация - объект инициализируется при первом вызове метода getInstance();

2. По образу и подобию в отдельных файлах создать три синглтон класса Sun, Moon, Earth.
3. Реализовать интерфейс Planet для классов Sun, Moon, Earth.
4. В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet.
5. Реализовать функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считать один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, то создать соответствующий объект
и присвоить его Planet thePlanet, иначе обнулить Planet thePlanet.
5.3. Сравнивать введенный параметр можно только с константами из Planet, нельзя создавать свои строки.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException
    {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String param = br.readLine();

        if(param.equals(Planet.SUN))
        {
            thePlanet = Sun.getInstance();
           // System.out.println(thePlanet);
        }
        else if(param.equals(Planet.EARTH))
        {
            thePlanet = Earth.getInstance();
            //System.out.println(thePlanet);
        }
        else if (param.equals(Planet.MOON))
        {
            thePlanet = Moon.getInstance();
            //System.out.println(thePlanet);
        }
        else
        {
            thePlanet=null;
            //System.out.println(thePlanet);
        }
    }
    static {
        try
        {
            readKeyFromConsoleAndInitPlanet();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) throws IOException
    {
        readKeyFromConsoleAndInitPlanet();
    }*/

}
