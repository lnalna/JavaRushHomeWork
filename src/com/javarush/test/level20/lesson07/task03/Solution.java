package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {

    public static void main(String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial20_07_03")))
        {
            Person father = new Person("fatherFN","fatherLN",32);
            Person mother = new Person("motherFN","motherLN",27);
            Person child1 = new Person("childFN1","childLN1",5);
            Person child2 = new Person("childFN2","childLN2",2);

            List<Person> children = new ArrayList<>();
            children.add(child1);
            children.add(child2);

            Person person = new Person();

            person.setFather(father);
            person.setMother(mother);
            person.setChildren(children);


            System.out.println("---Before serialization---");
            System.out.println("fatherFN = "+father.firstName+" fatherLN = "+father.lastName+" fatherAge = "+father.age);
            System.out.println("motherFN = "+mother.firstName+" motherLN = "+mother.lastName+" motherAge = "+mother.age);

            for(Person temp: children)
                System.out.println(temp.firstName+" "+temp.lastName+" "+temp.age);

            System.out.println("---Before serialization---");

            person.writeExternal(objOStrm);

        }
        catch (IOException e)
        {
            System.out.println("Ошибка сериализации : " + e);
        }


        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial20_07_03")))
        {
            Person loadPerson= new Person();
            loadPerson.readExternal(objIStrm);



            //System.out.println("---After deserialization---");
            //System.out.println("fatherFN = "+lFather.firstName+" fatherLN = "+lFather.lastName+" fatherAge = "+lFather.age);
            //System.out.println("motherFN = "+lMother.firstName+" motherLN = "+lMother.lastName+" motherAge = "+lMother.age);



            //System.out.println("---After deserialization---");

        }
        catch (Exception e)
        {
            System.out.println("Ошибка десериализации : " + e);
            System.exit(0);
        }
    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;
        private static final long serialVersionUID = 1L; //добавил переменную


        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person(){
            super();
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children = (List<Person>)in.readObject();
        }
    }
}
