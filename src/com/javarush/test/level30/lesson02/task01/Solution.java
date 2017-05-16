package com.javarush.test.level30.lesson02.task01;


/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {

        int numerationSystem=10;
        String number = s;

        char[] temp  = s.toCharArray();

        if(temp[0] == '0' & temp[1] == 'x'){
            numerationSystem = 16;
            number = s.substring(2);
        }

        if(temp[0] == '0' & temp[1] != 'b' & temp[1] != 'x'){
            numerationSystem = 8;
            number = s.substring(1);
        }
        if(temp[0] == '0' & temp[1] == 'b'){
            numerationSystem = 2;
            number = s.substring(2);
        }


        return Integer.parseInt(number,numerationSystem)+"";
    }
}
