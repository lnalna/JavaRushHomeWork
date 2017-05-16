package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/


import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        Pattern pat = Pattern.compile("(\\b)[0-9]+(\\s|\\b)");
        Matcher mat = pat.matcher(outputStream.toString());

        int a=0;
        int b=0;
        int i=0;
        while(mat.find())
        {
            i++;
            if (i == 1) a =Integer.parseInt(mat.group().trim());
            if (i == 2) b =Integer.parseInt(mat.group().trim());
        }

        String temp = outputStream.toString();
        if (temp.contains("+"))
        {
            System.setOut(consoleStream);
            int c=a+b;
            System.out.printf("%s + %s = %s",a,b,c);
        }
        if (temp.contains("-"))
        {
            System.setOut(consoleStream);
            int c=a-b;
            System.out.printf("%s - %s = %s",a,b,c);
        }

        if (temp.contains("*"))
        {
            System.setOut(consoleStream);
            int c=a*b;
            System.out.printf("%s * %s = %s",a,b,c);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

