package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.*;



/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/tmp/task_20_02_02.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("UserFirstName");
            user.setLastName("UserLastName");

            Calendar birthdayCalendar = new GregorianCalendar();
            birthdayCalendar.set(1990, 9, 5);//05-01-1990 т.к. month-1
            user.setBirthDate(birthdayCalendar.getTime());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            User user2 = new User();
            user2.setFirstName("UserFirstName2");
            user2.setLastName("UserLastName2");
            birthdayCalendar.set(1991, 10, 5);//05-01-1990 т.к. month-1
            user2.setBirthDate(birthdayCalendar.getTime());
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user2);

            User user3 = new User();
            user3.setFirstName("UserFirstName3");
            user3.setLastName("UserLastName3");
            birthdayCalendar.set(1992, 11, 5);//05-01-1990 т.к. month-1
            user3.setBirthDate(birthdayCalendar.getTime());
            user3.setMale(true);
            user3.setCountry(User.Country.OTHER);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            if(javaRush.equals(loadedObject))
                System.out.println("javaRush object equal loadedObject");

            for(User u: loadedObject.users)
            {
                System.out.println("--------------------");
                System.out.println("UserFirstName = "+u.getFirstName());
                System.out.println("UserLastName = "+u.getLastName());
                System.out.println("User BirthDate = "+u.getBirthDate());
                System.out.println("User is male = "+u.isMale());
                System.out.println("User Country = "+u.getCountry());
                System.out.println("--------------------");
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            String isUsers = users !=null ? "yes" : "no";

            printWriter.println(isUsers);
            printWriter.println(users.size());

            if("yes".equals(isUsers))
            {
                for(User u : users)
                {
                    printWriter.println(u.getFirstName());
                    printWriter.println(u.getLastName());
                    Date tempDate=u.getBirthDate();
                    printWriter.println(tempDate);
                    printWriter.println(u.isMale());
                    printWriter.println(u.getCountry().getDisplayedName());
                }
            }

            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isUsers = reader.readLine();
            String size = reader.readLine();

            if("yes".equals(isUsers))
            {
                users = new ArrayList<User>();

                for(int i=0;i<Integer.parseInt(size);i++)
                {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());

                    String tempDate[] = reader.readLine().split(" ");
                    for(String temp:tempDate)
                    temp=temp.trim();
                    Calendar birthdayCalendar = new GregorianCalendar();
                    int year=Integer.parseInt(tempDate[5]);

                    int month=0;
                    switch(tempDate[1].toUpperCase())
                    {
                        case "JAN": month=Calendar.JANUARY; break;
                        case "FEB": month=Calendar.FEBRUARY; break;
                        case "MAR":month=Calendar.MARCH; break;
                        case "APR": month=Calendar.APRIL; break;
                        case "MAY": month=Calendar.MAY; break;
                        case "JUN": month=Calendar.JUNE; break;
                        case "JUL": month=Calendar.JULY; break;
                        case "AUG": month=Calendar.AUGUST; break;
                        case "SEP": month=Calendar.SEPTEMBER; break;
                        case "OCT": month=Calendar.OCTOBER; break;
                        case "NOV": month=Calendar.NOVEMBER; break;
                        case "DEC": month=Calendar.DECEMBER; break;
                    }
                    int day = Integer.parseInt(tempDate[2]);

                    birthdayCalendar.set(year,month,day);//05-01-1990 т.к. month-1
                    user.setBirthDate(birthdayCalendar.getTime());

                    user.setMale(Boolean.parseBoolean(reader.readLine()));

                    String country = reader.readLine();
                    if(country.equals("Ukraine"))
                    {
                        user.setCountry(User.Country.UKRAINE);
                    }
                    if(country.equals("Russia"))
                    {
                        user.setCountry(User.Country.RUSSIA);
                    }
                    if(country.equals("Other"))
                    {
                        user.setCountry(User.Country.OTHER);
                    }

                    users.add(user);
                }
            }
        }
    }
}
