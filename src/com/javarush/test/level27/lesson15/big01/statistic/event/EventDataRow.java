package com.javarush.test.level27.lesson15.big01.statistic.event;

/**
 * Created by admin on 17.06.15.
 */
import java.util.Date;

public interface EventDataRow
{
    EventType getType();

/*    4. В EventDataRow создайте методы
    Date getDate(), реализация которого вернет дату создания записи
    int getTime(), реализация которого вернет время - продолжительность
*/
    Date getDate();
    int getTime();
}
