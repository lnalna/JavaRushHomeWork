package com.javarush.test.level19.lesson03.task04;

import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.*;



/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {

    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File("C:/file.txt"));
        PersonScanner adapter = new PersonScannerAdapter(s);
        System.out.println(adapter.read());
        adapter.close();

    }
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner=scanner;
        }


        public Person read() throws IOException
       {
           Person person = null;
           while (scanner.hasNext())
           {
               String lastName = scanner.next(); //Иванов
               String firstName = scanner.next();//Иван
               String middleName = scanner.next();//Иванович
               int day = scanner.nextInt();
               int month = scanner.nextInt()-1;
               int year = scanner.nextInt();
               GregorianCalendar date = new GregorianCalendar(year,month,day);
               return new Person(firstName,middleName,lastName,date.getTime());

           }

           return person;
       }

       public void close() throws IOException
        {
            scanner.close();
        }
    }
}
