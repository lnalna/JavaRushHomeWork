package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.Collection;
import java.util.ResourceBundle;
import com.javarush.test.level26.lesson15.big01.CashMachine;

/**
 * Created by admin on 01.04.15.
 */
class InfoCommand implements Command
{
/*
    8.2.2.2 В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
    Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
    Все работает правильно?
    EUR - 200
    USD - 120
    Отлично!
 */
 private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute()  throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        Collection<CurrencyManipulator> allManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        if(allManipulators.size() <=0)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }

        for(CurrencyManipulator currencyManipulator : allManipulators)
        {
            if(currencyManipulator.hasMoney()){
                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            }else{
                ConsoleHelper.writeMessage(res.getString("no.money"));
            }

        }


    }
}
