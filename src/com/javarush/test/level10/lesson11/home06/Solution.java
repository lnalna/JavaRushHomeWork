package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/


public class Solution
{
    public static void main(String[] args)
    {

    }

   // public static class Human
    //{
        //напишите тут ваши переменные и конструкторы
   // }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        String city;
        String house;
        boolean child_flag;
// 1
        Human(String name,int age)
        {
            this.name=name;
            this.age=age;
        }
// 2
        Human(String name)
        {
            this.name=name;
        }
// 3
        Human(String name, boolean sex)
        {
            this.name=name;
            this.sex=sex;
        }

//4
        Human(String name, boolean sex, int age)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
        }
//5
        Human(String name, boolean sex, int age, String city)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.city=city;
        }
//6
        Human(String name,  int age, String house)
        {
            this.name=name;
           // this.sex=sex;
            this.age=age;
            this.house=house;
        }
//7
        Human(String name, boolean sex, int age, String city, String house)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.city=city;
            this.house=house;
        }

 //8
        Human(String name, boolean sex, int age, boolean child_flag)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.child_flag = child_flag;

            if(child_flag)
            {
                System.out.println("children");
            }
        }
//9
        Human(String name, boolean sex, int age, boolean child_flag, String city)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.city=city;
            this.child_flag = child_flag;

            if(child_flag)
            {
                System.out.println("children");
            }
        }
//10
        Human(String name, boolean sex, int age, boolean child_flag, String city,String house)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.city=city;
            this.house=house;
            this.child_flag = child_flag;

            if(child_flag)
            {
                System.out.println("children");
            }
        }
    }

}
