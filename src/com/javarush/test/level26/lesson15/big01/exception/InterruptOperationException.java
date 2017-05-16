package com.javarush.test.level26.lesson15.big01.exception;

/**
 * Created by admin on 31.03.15.
 *
 * 2. Создадим пакет exception, в который поместим два checked исключения:
 2.1 InterruptOperationException будем кидать, когда нужно прервать текущую операцию и выйти из приложения
 2.2 NotEnoughMoneyException будем кидать, когда не сможем выдать запрашиваемую сумму
 */
public class InterruptOperationException extends Exception
{
}
