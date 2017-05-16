package com.javarush.test.level21.lesson16.big01;

/**
 * Created by admin on 20.02.15.
 */

import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void addHorse(Horse horse)
    {
        if (horses != null)
            horses.add(horse);
    }

    public static void main(String[] args)  throws Exception
    {
        game = new Hippodrome();

        game.addHorse(new Horse("horse1", 3, 0));
        game.addHorse(new Horse("horse2", 3, 0));
        game.addHorse(new Horse("horse3", 3, 0));

        game.run();
        game.printWinner();
    }

    public void run() throws Exception
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();

            Thread.sleep(5);
        }
    }

    public void move()
    {
        for (Horse horse: horses)
            horse.move();
    }

    public void print()
    {
        for (Horse horse: horses)
            horse.print();

        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        if (horses != null && horses.size() > 0)
        {
            if (horses.size() == 1)
                return horses.get(0);
            else
            {
                Horse winner = horses.get(0);
                for (Horse horse: horses)
                    if (horse.getDistance() > winner.getDistance())
                        winner = horse;
                return winner;
            }
        }
        else
            return null;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}
