package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 31.03.15.
 *
 *3.2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
 Создадим класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
 В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
 Подумайте, где лучше хранить все манипуляторы.
 Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса
 */



public class CurrencyManipulatorFactory
{
  /* 8.2. Давайте запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
    Ничего не понятно, т.к. создались 2 манипулятора: первый для EUR, второй для USD.
    Давайте улучшим логику InfoCommand. Надо вывести баланс по каждому манипулятору.

       8.2 2.1. В классе CurrencyManipulatorFactory создайте статический метод getAllCurrencyManipulators(),
        который вернет все манипуляторы.
    У вас все манипуляторы хранятся в карте, не так ли? Если нет, то рефакторьте.
    8.2.2.2 В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
    Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
    Все работает правильно?
    EUR - 200
    USD - 120
    Отлично!
*/

    private static Map<String,CurrencyManipulator> manipulators =  new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
   {
      if(!manipulators.containsKey(currencyCode))
          manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));

       return manipulators.get(currencyCode);
   }

    /*2.1. В классе CurrencyManipulatorFactory создайте статический метод getAllCurrencyManipulators(),
    который вернет все манипуляторы.
    У вас все манипуляторы хранятся в карте, не так ли? Если нет, то рефакторьте.
    */
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }
}
