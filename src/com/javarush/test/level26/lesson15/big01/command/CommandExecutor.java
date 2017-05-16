package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 01.04.15.
 *
 * 7.4. Создадим public класс CommandExecutor, через который можно будет взаимодействовать со всеми командами.
 Создадим ему статическую карту Map<Operation, Command>, которую проинициализируем всеми известными нам операциями
 и командами.

 7.4.1 Создадим метод public static final void execute(Operation operation), который будет дергать метод execute
 у нужной команды.
 Реализуйте эту логику.
 7.4.2. Расставьте правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.

 */
public class CommandExecutor
{
    private CommandExecutor(){}

    private static Map<Operation, Command> map;

    static
    {
             map = new HashMap<>();
             map.put(Operation.LOGIN, new LoginCommand());
             map.put(Operation.INFO, new InfoCommand());
             map.put(Operation.DEPOSIT, new DepositCommand());
             map.put(Operation.WITHDRAW, new WithdrawCommand());
             map.put(Operation.EXIT, new ExitCommand());
    }

   final public static void execute(Operation operation) throws InterruptOperationException {
        map.get(operation).execute();
   }

}
