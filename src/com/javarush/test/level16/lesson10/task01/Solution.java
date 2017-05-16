package com.javarush.test.level16.lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;
        private Date start_time,end_time;
        public void run() {
            try {
                //add your code here - добавьте код тут
                 start_time = new Date();
                Thread current =Thread.currentThread();
                while(!current.isInterrupted())
                {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                 end_time= new Date();
                 seconds= (int) ((end_time.getTime()-start_time.getTime())/1000);
                System.out.println(seconds);
            }
        }
    }
}
