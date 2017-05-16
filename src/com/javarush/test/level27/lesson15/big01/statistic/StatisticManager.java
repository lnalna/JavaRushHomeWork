package com.javarush.test.level27.lesson15.big01.statistic;

/**
 * Created by admin on 17.06.15.
 */import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();
    private Set<Cook> cookSet = new HashSet<>();
    public static StatisticManager getInstance() {
        return ourInstance;
    }
    private StatisticManager() { }
    public void register(EventDataRow data) {
        storage.put(data);
    }
    public void register(Cook cook) {
        cookSet.add(cook);
    }
    public TreeMap<Date, Double> getAdvProfitByDays() {
        List<VideoSelectedEventDataRow> advList = new ArrayList<>();
        for (EventDataRow eventDataRow : storage.get(EventType.SELECTED_VIDEOS))
            advList.add((VideoSelectedEventDataRow) eventDataRow);         //Avoid unchecked warning
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        TreeMap<Date, Double> dateProfitMap = new TreeMap<>(Collections.reverseOrder());
        try {
            for (VideoSelectedEventDataRow videoEvent : advList) {
                Date date = sdf.parse(sdf.format(videoEvent.getDate()));  //Round date to day
                if (!dateProfitMap.containsKey(date))
                    dateProfitMap.put(date, 0d);
                Double dProfit = dateProfitMap.get(date);
                dateProfitMap.put(date, dProfit + videoEvent.getAmount()/ 100.0);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return dateProfitMap;
    }
    public TreeMap<Date, TreeMap<String, Double>> getLoadByDateByCook() {
        List<CookedOrderEventDataRow> cookEvents = new ArrayList<>();
        for (EventDataRow eventDataRow : storage.get(EventType.COOKED_ORDER))
            cookEvents.add((CookedOrderEventDataRow) eventDataRow);         //Avoid unchecked warning
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        TreeMap<Date, TreeMap<String, Double>> resMap = new TreeMap<>(Collections.reverseOrder());//Sort Date in descending order
        try {
            for (CookedOrderEventDataRow cookEvent : cookEvents) {
                Date date = sdf.parse(sdf.format(cookEvent.getDate()));//Round date to day
                if (!resMap.containsKey(date))
                    resMap.put(date, new TreeMap<String, Double>());
                TreeMap<String, Double> nameLoadMap = resMap.get(date);
                String cookName = cookEvent.getCookName();
                if (!nameLoadMap.containsKey(cookName))
                    nameLoadMap.put(cookName, 0d);
                Double dLoad = nameLoadMap.get(cookName);
                nameLoadMap.put(
                        cookName, dLoad + Math.ceil(cookEvent.getTime() / 60.0) //sec to minutes round to high
                );
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return resMap;
    }
    private static class StatisticStorage {
        private Map<EventType, List<EventDataRow>> typeListMap = new TreeMap<>();
        private StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                typeListMap.put(eventType, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data) {
            typeListMap.get(data.getType()).add(data);
        }
        private List<EventDataRow> get(EventType eventType) {
            return typeListMap.get(eventType);
        }
    }
}