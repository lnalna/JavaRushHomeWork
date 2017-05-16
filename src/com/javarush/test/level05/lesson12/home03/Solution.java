package com.javarush.test.level05.lesson12.home03;




public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Cat   tomCat = new Cat("Tom",100,20);
        Dog   spikeDog = new Dog("Spike",120,10);

        //Напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //Напишите тут ваши классы

    public static class Dog
    {
        String name;
        int height;
        int tail;

        public Dog(String name,int height,int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int height;
        int tail;

        public Cat(String name,int height,int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

}
