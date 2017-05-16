package com.javarush.test.level20.lesson07.task01;



import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {


    public static void main(String[] args)
    {

        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial20_07_01")))
        {
            Apartment apartment = new Apartment("address test",1990);

            System.out.println("---Apartment before serialization---");
            System.out.println(apartment.toString());
            System.out.println("---Apartment before serialization---");

            apartment.writeExternal(objOStrm);

        }
        catch (IOException e)
        {
            System.out.println("Ошибка сериализации : " + e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial20_07_01")))
        {
            Apartment loadApartment = new Apartment();
            loadApartment.readExternal(objIStrm);

            System.out.println();
            System.out.println("---Apartment after deserialization---");
            System.out.println(loadApartment.toString());
            System.out.println("---Apartment after deserialization---");


        }
        catch (Exception e)
        {
            System.out.println("Ошибка десериализации : " + e);
            System.exit(0);
        }

    }

    public static class Apartment implements Externalizable {

        private  String address;
        private int year;
        private static final long serialVersionUID = 1L;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }



        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }


        @Override
        public void writeExternal(ObjectOutput objectOutput) throws IOException {

            objectOutput.writeObject(address);
            objectOutput.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            address = (String)objectInput.readObject();
            year = objectInput.readInt();
        }
    }
}

