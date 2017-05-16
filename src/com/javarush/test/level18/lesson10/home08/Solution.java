package com.javarush.test.level18.lesson10.home08;



/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args)throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

            String fileName="";
            while(!fileName.equals("exit")){
               fileName = bufferedReader.readLine();
               list.add(fileName);
            }
            bufferedReader.close();
            for(String s : list){
                ReadThread readThread = new ReadThread(s);
                readThread.start();
                try
                {
                    readThread.join();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }


  //      try
    //    {
      //      Thread.sleep(10000);
        //}
        //catch (InterruptedException e)
        //{
          //e.printStackTrace();
       // }
        //System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try{
                FileInputStream in = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (in.available()>0){
                    int data = in.read();
                    list.add(data);
                }
                in.close();

                int max = 0;
                int id = 0;

                for(int a = 0;a<list.size();a++){
                    int count = Collections.frequency(list,list.get(a));
                    if(count>max){ max = count; id = list.get(a);}
                }

                resultMap.put(fileName,id);

            }catch (Exception e){}
        }
    }
}