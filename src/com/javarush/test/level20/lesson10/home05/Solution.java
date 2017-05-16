package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution {

    public static void main(String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/C:/tmp/serial20_10_05")))
        {
            Person person = new Person("P_First_Name1","P_Last_Name1","P_Country1",Sex.MALE);

            System.out.println("---Person before serialization---");
            System.out.println("Person firstName = "+person.firstName);
            System.out.println("Person lastName = "+person.lastName);
            System.out.println("Person fullName = "+person.fullName);
            System.out.println("Person greetingString = "+person.greetingString);
            System.out.println("Person Country = "+person.country);
            System.out.println("Person sex = "+person.sex);
            System.out.println("Perosn outputStream = "+person.outputStream);
            System.out.println("Perosn logger = "+person.logger);
            System.out.println("---Person before serialization---");
            System.out.println();

            objOStrm.writeObject(person);


        }catch (IOException e)
        {
            System.out.println("Error  during in serialization "+e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/C:/tmp/serial20_10_05")))
        {
            Person loadPerson = (Person)objIStrm.readObject();

            System.out.println("---loadPerson after deserialization---");
            System.out.println("loadPerson firstName = "+loadPerson.firstName);
            System.out.println("loadPerson lastName = "+loadPerson.lastName);
            System.out.println("loadPerson fullName = "+loadPerson.fullName);
            System.out.println("loadPerson greetingString = "+loadPerson.greetingString);
            System.out.println("loadPerson Country = "+loadPerson.country);
            System.out.println("loadPerson sex = "+loadPerson.sex);
            System.out.println("loadPerosn outputStream = "+loadPerson.outputStream);
            System.out.println("loadPerosn logger = "+loadPerson.logger);
            System.out.println("---loadPerson after deserialization---");

        }
        catch (Exception e)
        {
            System.out.println("Error during deserialization "+e);
        }
    }

    public static class Person implements Serializable{

        private static final long serialVersionUID = 1L;

        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        public Person()
        {
           super();
           this.greetingString = "Hello, ";

        }

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

    }

    enum Sex {
        MALE,
        FEMALE
    }
}
