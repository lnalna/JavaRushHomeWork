package com.javarush.test.level20.lesson04.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* Как сериализовать JavaRush?
Сделайте так, чтобы сериализация класса JavaRush была возможной
*/
public class Solution {

    public static void main(String[] args)
    {

        try( ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial_20_04_02")))

        {
            JavaRush javaRush = new JavaRush();

            User user = new User();
            user.setFirstName("UserFirstName");
            user.setLastName("UserLastName");

            Calendar birthdayCalendar = new GregorianCalendar();
            birthdayCalendar.set(1990, 9, 5);//05-01-1990 т.к. month-1
            user.setBirthDate(birthdayCalendar.getTime());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            for(User u: javaRush.users)
            {
                System.out.println("---Before serialization---");
                System.out.println("UserFirstName = "+u.getFirstName());
                System.out.println("UserLastName = "+u.getLastName());
                System.out.println("User BirthDate = "+u.getBirthDate());
                System.out.println("User is male = "+u.isMale());
                System.out.println("User Country = "+u.getCountry());
                System.out.println("---Before serialization---");
            }
            System.out.println();

            objOStrm.writeObject(javaRush);
        }
        catch(IOException e)
        {
            System.out.println("Исключение во время сериализации : " + e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial_20_04_02")))
        {
            JavaRush loadJavaRush = (JavaRush)objIStrm.readObject();

            for(User u: loadJavaRush.users)
            {
                System.out.println("---After deserialization---");
                System.out.println("UserFirstName = "+u.getFirstName());
                System.out.println("UserLastName = "+u.getLastName());
                System.out.println("User BirthDate = "+u.getBirthDate());
                System.out.println("User is male = "+u.isMale());
                System.out.println("User Country = "+u.getCountry());
                System.out.println("---After deserialization---");
            }
        }
        catch (Exception e)
        {
            System.out.println("Исключение во время сериализации : " + e);
            System.exit(0);
        }


    }
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }
}
