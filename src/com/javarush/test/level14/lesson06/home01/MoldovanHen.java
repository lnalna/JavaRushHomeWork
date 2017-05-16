package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nik on 03.11.14.
 */
public class MoldovanHen extends Hen implements Country
{
    int  getCountOfEggsPerMonth()
    {
        return 12;
    }

    public String getDescription()
    {
     /*
     <getDescription() родительского класса>  + <" Моя страна - SSSSS. Я несу N яиц в месяц.">
где SSSSS - название страны
где N - количество яиц в месяц

     */

        return super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
