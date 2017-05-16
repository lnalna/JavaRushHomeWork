package com.javarush.test.level26.lesson15.big01;

/**
 * Created by admin on 31.03.15.
 *
 * 6.1. В энум Operation добавьте статический метод Operation getAllowableOperationByOrdinal(Integer i)
 Должен возвращать элемент энума: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
 На некорректные данные бросать IllegalArgumentException
 */
public enum Operation
{
   LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        switch (i)
        {
            case 0: throw new IllegalArgumentException();
            case 1: return INFO;
            case 2: return DEPOSIT;
            case 3: return WITHDRAW;
            case 4: return EXIT;
            default: throw new IllegalArgumentException();

        }
    }
}
