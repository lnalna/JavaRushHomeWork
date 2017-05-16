package com.javarush.test.level26.lesson10.home02;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nik on 27.03.15.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {

        try{
            int i = 1;
            Thread currentThread = Thread.currentThread();
            while (!currentThread.isInterrupted())
            {
                map.put(String.valueOf(i), "Some text for "+String.valueOf(i++));
                Thread.sleep(500);
            }

        }catch (Exception e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
