package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
public class Solution implements Serializable {
    public static void main(String[] args) {

        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/tmp/serial20_07_04")))
        {
            Solution solution = new Solution(4);
            //System.out.println(new Solution(4));
            System.out.println(solution);

           objOStrm.writeObject(solution);

        }
        catch (IOException e)
        {
            System.out.println("Error = "+e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/tmp/serial20_07_04")))
        {
            Solution loadSolution=(Solution)objIStrm.readObject();
            System.out.println();
            System.out.println(loadSolution);
        }
        catch (Exception e)
        {
            System.out.println("Error = "+e);
        }

    }

    transient    private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;
    private static final long serialVersionUID = 1L; //добавил переменную

    public Solution()
    {
      //  super();

    }
    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
