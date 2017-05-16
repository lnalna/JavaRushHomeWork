package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandfather1 = new Human("GrandFather1",true,99,false);
        Human grandfather2 = new Human("GrandFather2",true,98,false);
        Human grandmother1 = new Human("GrandMother1",false,99,false);
        Human grandmother2 = new Human("GrandMother2",false,98,false);
        Human father = new Human("Father",true,50,false);
        Human mother = new Human("Mother",false,48,false);
        Human child1 = new Human("child1",true,20,true);
        Human child2 = new Human("child2",true,22,true);
        Human child3 = new Human("child3",false,18,true);
        //    ArrayList<Human> HUMAN = Human.children;

//        System.out.println(grandfather1.toString());
  //      System.out.println(child1.toString());
System.out.println(grandfather1.toString());
System.out.println(grandfather2.toString());
System.out.println(grandmother1.toString());
System.out.println(grandmother2.toString());
System.out.println(father.toString());
System.out.println(mother.toString());
System.out.println(child1.toString());
System.out.println(child2.toString());
System.out.println(child3.toString());

    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        boolean child_flag;

        ArrayList<Human> children = new ArrayList<Human>();

        Human(String name,boolean sex,int age,boolean child_flag)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.child_flag=child_flag;

            if (child_flag)
            children.add(this);
        }



        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
