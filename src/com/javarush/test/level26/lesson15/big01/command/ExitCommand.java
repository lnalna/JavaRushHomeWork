package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.ResourceBundle;
import com.javarush.test.level26.lesson15.big01.CashMachine;


/**
 * Created by admin on 01.04.15.
 */
class ExitCommand implements Command
{
/*    Задание 9
    Сегодня мы займемся командой ExitCommand.
    1. Реализуйте следующую логику в команде ExitCommand:
        1.1. Спросить, действительно ли пользователь хочет выйти - варианты <y,n>.
    1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.
*/
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        if (ConsoleHelper.readString().equals(res.getString("yes")))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}
