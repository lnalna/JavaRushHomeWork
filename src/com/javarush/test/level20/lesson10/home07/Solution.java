package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args)throws Exception
    {
            Solution solution = new Solution("C:\\tmp\\serial20_10_07_obj");
            solution.writeObject("test");
            solution.close();

            //SAVE
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\tmp\\serial20_10_07.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(solution);
            outputStream.flush();
            outputStream.close();
            //LOAD
            FileInputStream fileInputStream = new FileInputStream("C:\\tmp\\serial20_10_07.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Solution t2 = (Solution) inputStream.readObject();
            inputStream.close();
            t2.writeObject("Hi2");


    }

    transient private FileOutputStream stream;
    private String fileName;
    private static final long serialVersionUID = 1L;


    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
      //  fileName = (String)in.readObject();
        stream = new FileOutputStream(fileName,true);
      //  in.close();

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
