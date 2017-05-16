package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        // Создай по два объекта каждого класса тут
        Man man1 = new Man("Man1",30,"Russia");
        Man man2 = new Man("Man2",31,"USA");
        Woman woman1 = new Woman("Woman1",29,"Russia");
        Woman woman2 = new Woman("Woman2",30,"USA");

        System.out.println(man1.getInfo());
        System.out.println(man2.getInfo());
        System.out.println(woman1.getInfo());
        System.out.println(woman2.getInfo());


        // Выведи их на экран тут
    }

    // Напиши тут свои классы

    public static class Man
    {
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getInfo()
        {
            String result_string="["+name+" "+age+" "+address+"]";
            return result_string;
        }
    }

    public static class Woman
    {
        private String name;
        private int age;
        private String address;


        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public String getInfo()
        {
            String result_string="["+name+" "+age+" "+address+"]";
            return result_string;
        }

    }

}
