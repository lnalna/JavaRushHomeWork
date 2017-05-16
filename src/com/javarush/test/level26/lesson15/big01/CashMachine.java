package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by admin on 31.03.15.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);
            try
            {
                CommandExecutor.execute(Operation.LOGIN);
                Operation operation = null;
                do
                {
                  operation=ConsoleHelper.askOperation();
                  CommandExecutor.execute(operation);

                }while(!Operation.EXIT.toString().equals(operation.toString().toUpperCase()));

            }catch (InterruptOperationException e )
            {
                try {
                    CommandExecutor.execute(Operation.EXIT);
                } catch (InterruptOperationException ignored) {
                }
                ConsoleHelper.printExitMessage();
            }
    }
}
