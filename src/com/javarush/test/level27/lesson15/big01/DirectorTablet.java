package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;


import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        TreeMap<Date, Double> advProfitByDays = StatisticManager.getInstance().getAdvProfitByDays();
        double totalProfit = 0;
        for (Map.Entry<Date, Double> entry : advProfitByDays.entrySet()) {
            Double dProfit = entry.getValue();
            System.out.println(String.format(
                    "%1$td-%1$tb-%1$tY - %2$.2f",        //Print date dd-MMM-yyyy
                    entry.getKey(),
                    dProfit
            ));
            totalProfit += dProfit;
        }
        System.out.println(String.format("Total - %.2f", totalProfit));
    }
    public void printCookWorkloading() {
        TreeMap<Date, TreeMap<String, Double>> loadByDateByCook = StatisticManager.getInstance().getLoadByDateByCook();
        for (Map.Entry<Date, TreeMap<String, Double>> entry : loadByDateByCook.entrySet()) {
            System.out.println(String.format(               //Print date dd-MMM-yyyy
                    "\n%1$td-%1$tb-%1$tY",
                    entry.getKey()
            ));
            TreeMap<String, Double> nameLoadMap = entry.getValue();
            for (Map.Entry<String, Double> nameLoadEntry : nameLoadMap.entrySet()) {
                System.out.println(String.format(
                        "%s - %d min",
                        nameLoadEntry.getKey(),
                        (int) (double) nameLoadEntry.getValue()  // (int)Math.ceil(nameLoadEntry.getValue() / 60.0)
                ));
            }
        }
    }
    public void printActiveVideoSet() {}
    public void printArchivedVideoSet() {}
}