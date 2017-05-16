package com.javarush.test.level26.lesson15.big01;

import  java.util.*;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

/**
 * Created by admin on 31.03.15.
 *
 * 3.1. Создадим класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
 String currencyCode - код валюты, например, USD. Состоит из трех букв
 Map<Integer, Integer> denominations - это Map<номинал, количество>
 Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode
 Очевидно, что манипулятор никак не может функционировать без названия валюты,
 поэтому добавим конструктор с этим параметром и проинициализируем currencyCode
 */



public class CurrencyManipulator
{
    String currencyCode;
    Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    /*
    4.4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
    который добавит введенные номинал и количество банкнот
    */
    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else
        {
            denominations.put(denomination, count);
        }

    }
    /*
    5.1.В предыдущем таске мы реализовали основную логику операции DEPOSIT.
    Но посмотреть результат так и не удалось.
    Поэтому создадим в манипуляторе метод int getTotalAmount(), который посчитает общую сумму денег для выбранной валюты.
    */
    public int getTotalAmount()
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> map : denominations.entrySet())
            sum += map.getKey() * map.getValue();

        return sum;
    }

    /*8.3. Запустим прогу и сразу первой операцией попросим INFO. Ничего не вывело? Непорядок.
    Добавьте в манипулятор метод boolean hasMoney(), который будет показывать, добавлены ли какие-то банкноты или нет.
    */
    public boolean hasMoney()
    {
        boolean temp = false;

        if (denominations.size() > 0)
            temp = true;

        return temp;
    }

/*
10.1.3.3. Проверить, достаточно ли средств на счету.
Для этого в манипуляторе создайте метод boolean isAmountAvailable(int expectedAmount),
который вернет true, если денег достаточно для выдачи.
Если недостаточно, то вернуться к п. 1.3.
*/

    public boolean isAmountAvailable(int expectedAmount)
    {
        boolean temp = getTotalAmount() >= expectedAmount;
        return temp;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Transaction was successful!");
        }
        return result;
    }
}
