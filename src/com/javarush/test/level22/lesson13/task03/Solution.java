package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static void main(String[] args)
    {

        String temp = "+380501234567";
        boolean flag = checkTelNumber(temp);
        System.out.println(flag);

        //System.out.println(checkTelNumber("+38(050)1234567"));


    }

    public static boolean checkTelNumber(String telNumber) {
        boolean isValid = false;
        if (telNumber == null || telNumber == "")
            return isValid;

        //номер не содержит букв и в конце цифра пункты 6 и 7
        boolean isValidDefault = telNumber.matches("^[[^A-Z]&&[^a-z]&&[^А-Я]&&[^а-я]]*\\d$") &&
                //может содержать 1 пару скобок '(' и ')', причем если она есть, то она расположена левее знаков '-'
                //скобки внутри содержат четко 3 цифры
                telNumber.matches("[^-\\(\\)]*(\\(\\d{3}\\))?[^\\(\\)]*") &&
                //может содержать 0-2 знаков '-', которые не могут идти подряд
                telNumber.matches("[^-]*-?[^-]+-?[^-]+");   //("[^-]*-?[^-]+-?[^-]+-?[^-]*")

        boolean isNumberBegin = telNumber.matches("^[\\d\\(].*");
        boolean isPlusBegin = telNumber.matches("^[\\+].*");
        if (isNumberBegin) {
            isNumberBegin = telNumber.matches("([^\\d]*\\d[^\\d]*){10}");
            isValid = isValidDefault && isNumberBegin;
        } else if (isPlusBegin) {
            isPlusBegin = telNumber.matches("([^\\d]*\\d[^\\d]*){12}");
            isValid = isValidDefault && isPlusBegin;
        } else {
            isValid = isValidDefault;
        }

        return isValid;
    }
}
