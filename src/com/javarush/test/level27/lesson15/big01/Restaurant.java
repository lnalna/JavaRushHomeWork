package com.javarush.test.level27.lesson15.big01;

/**
 * Created by admin on 03.06.15.
 */

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;


import java.util.Locale;

public class Restaurant
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        Tablet tablet = new Tablet(5);
        Cook amigoCook = new Cook("Amigo");
        tablet.addObserver(amigoCook);

        Waitor waitor = new Waitor();
        amigoCook.addObserver(waitor);

        tablet.createOrder();
        new AdvertisementManager(7200).processVideos();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}

