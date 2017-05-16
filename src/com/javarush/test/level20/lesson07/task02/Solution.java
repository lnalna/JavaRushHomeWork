package com.javarush.test.level20.lesson07.task02;

import java.io.*;

/* OutputToConsole
Класс OutputToConsole должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static String greeting = "Hello world";


    public static void main(String[] args)
    {
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial20_07_02")))
        {
            OutputToConsole outputToConsole = new OutputToConsole(10);

            System.out.println("---OutputToConsole before serialization---");
            System.out.println("outputToConsole.i = "+outputToConsole.i);
            outputToConsole.outputToConsole(11);
            System.out.println();
            System.out.println("---OutputToConsole before serialization---");

            outputToConsole.writeExternal(objOStrm);
        }
        catch (IOException e)
        {
            System.out.println("Ошибка сериализации : " + e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial20_07_02")))
        {
            OutputToConsole loadOutputToConsole = new OutputToConsole(10);

            loadOutputToConsole.readExternal(objIStrm);

            System.out.println("---OutputToConsole after deserialization---");
            System.out.println("outputToConsole.i = "+loadOutputToConsole.i);
            loadOutputToConsole.outputToConsole(11);
            System.out.println();
            System.out.println("---OutputToConsole after deserialization---");
        }
        catch (Exception e)
        {
            System.out.println("Ошибка десериализации : " + e);
            System.exit(0);
        }
    }

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console by character.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int i = 8;
        private static final long serialVersionUID = 1L; //добавил переменную

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            i = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         *
         */

        public OutputToConsole(){
            super();
        }
        public OutputToConsole(int ii) {
            this.i = ii;
        }

        /**
         * Outputs to the console a static field of Solution class [greeting].
         * Has to use [charAt] method of String class
         */
        public void outputToConsole(int ii) {
            for (int i = 0; i < greeting.length(); i++)  {
                System.out.write(greeting.charAt(i));
            }
        }
    }
}
