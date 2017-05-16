package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/


public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null){

            throw new TooShortStringException();
        }

        if(string.equals("\t\t")) return "";

        int prob = 0;
        String[] string2 = string.split("\t");


        char[] string3 = string.toCharArray();

        for (int i = 0; i < string3.length; i++){
            String s = String.valueOf(string3[i]);
            if (s.equals("\t")) prob++;
        }

        if (prob < 2) throw new TooShortStringException();

        String ret = string2[1];

        return ret;
    }

    public static class TooShortStringException extends Exception {
    }
    public static void main(String[] args) throws Exception{

      //  String string = getPartOfString(null);

        //System.out.println(string);

        System.out.println(getPartOfString("\t dfwfwerfer \t frfer \t"));
    }

}