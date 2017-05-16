package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public Object clone() throws CloneNotSupportedException
        {
            return new A(this.getI(), this.getJ());
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) throws CloneNotSupportedException
        {
            super(i, j);
            this.name = name;

        }

        public String getName() {
            return name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) throws CloneNotSupportedException
        {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException
        {
            return new C(this.getI(),this.getJ(),this.getName());
        }

    }



    public static void main(String[] args) throws CloneNotSupportedException
    {
       // C c = new C(1,2,"test");
        C c = new C(1,2,null);
        C clone = null;
        try {
            clone = c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try
        {
            System.out.println("-Begin c fields-");
            System.out.println(c.clone().getI());
            System.out.println(c.clone().getJ());
            System.out.println(c.clone().getName());
            System.out.println("-End c fileds-");

            System.out.println("-Begin clone fields-");
            System.out.println(clone.clone().getI());
            System.out.println(clone.clone().getJ());
            System.out.println(clone.clone().getName());
            System.out.println("-End clone fileds-");
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        System.out.println("-Begin Object c-");
        System.out.println(c);
        System.out.println("-End Object c-");
        System.out.println();

        System.out.println("-Begin Object clone-");
        System.out.println(clone);
        System.out.println("-End Object clone-");

        //System.out.println(tree.branches);
        //System.out.println(clone.branches);
    }

}
