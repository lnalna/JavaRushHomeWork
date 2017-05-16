package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("/tmp/task_20_02_04.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            System.out.println("--classWithStatic---");
            System.out.println("ClassWithStatic staticString = "+ClassWithStatic.staticString);
            System.out.println("classWithStatic i = "+classWithStatic.i);
            System.out.println("classWithStatic j = "+classWithStatic.j);
            System.out.println("--classWithStatic---");

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            if(classWithStatic.equals(loadedObject))
                System.out.println("classWithStatic equals loadedObject");


            System.out.println("--loadedObject---");
            System.out.println("ClassWithStatic staticString = "+ClassWithStatic.staticString);
            System.out.println("loadedObject i = "+loadedObject.i);
            System.out.println("loadedObject j = "+loadedObject.j);
            System.out.println("--loadedObject---");

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

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            String isClassWithStatic = this != null ? "yes":"no";

            printWriter.println(isClassWithStatic);
            printWriter.println(staticString);
            printWriter.println(i);
            printWriter.println(j);

            printWriter.flush();
            printWriter.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isClassWithStatic = reader.readLine();

            if("yes".equals(isClassWithStatic))
            {
                this.staticString=reader.readLine();
                this.i=Integer.parseInt(reader.readLine());
                this.j=Integer.parseInt(reader.readLine());
            }
            reader.close();
        }
    }
}
