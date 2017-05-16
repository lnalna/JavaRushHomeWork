package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by admin on 31.03.15.
 */
public class ConsoleHelper
{

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

/*
Задание 2
1. Создадим в ConsoleHelper два статических метода:
1.1 writeMessage(String message), который будет писать в консоль наше сообщение
1.2 String readString(), который будет считывать с консоли строку и возвращать ее.
 Если возникнет какое-то исключение при работе с консолью, то не будем его обрабатывать.
Кстати, создадим только один экземпляр BufferedReader-а
*/


    public static void  writeMessage(String message)
   {
       System.out.println(message);
   }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static String readString() throws InterruptOperationException
    {
        String line = null;

        try
        {
            line = reader.readLine();
            if(line.equalsIgnoreCase(res.getString("operation.EXIT")))
                throw new InterruptOperationException();


        }catch (IOException e)
        {

        }
        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
/*
4.2 Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Если данные валидны, то перевести код в верхний регистр и вернуть.
*/

        String currency_code="";
       do
        {
            writeMessage(res.getString("choose.currency.code"));
            currency_code = readString();
            if(currency_code.length()!=3)
                writeMessage(res.getString("invalid.data"));

        }while (currency_code.length()!=3);

        return currency_code.toUpperCase();
    }

/*
4.3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode)
в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Пример вводимых данных:
200 5
*/
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] array;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }

/*
6.2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
Спросить у пользователя операцию.
Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
Используйте метод, описанный в п.1.
Обработай исключение - запроси данные об операции повторно.

 */
    public static Operation askOperation() throws InterruptOperationException
    {

        writeMessage(res.getString("choose.operation"));
        writeMessage("Input code of Operation (1 - " + res.getString("operation.INFO") + ", 2 - " +
                res.getString("operation.DEPOSIT") + ", 3 - " + res.getString("operation.WITHDRAW") + ", 4 - " +
                res.getString("operation.EXIT") + ")...");
        Operation result = null;
        try
            {
                result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            }
        catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
                result = askOperation();
            }

        return result;
    }

}
