package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable{

    int node;
    List<Solution> edges = new LinkedList<>();
    private static final long serialVersionUID = 1L;

    public Solution()
    {

    }

    public Solution(int node)
    {
        this.node=node;
    }


    public static void main(String[] args)
    {
        Solution solution1 = new Solution();

        for(int i=0;i<6;i++)
          solution1.edges.add(new Solution(i));

        System.out.println("---Solution before serialization---");
        for(int j=0;j<solution1.edges.size();j++)
            System.out.println("solution1 "+j+" = "+solution1.edges.get(j));
        System.out.println("---Solution before serialization---");
        System.out.println();

        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("/C:/tmp/serial20_10_09")))
        {
            objOStrm.writeObject(solution1.edges);

        }catch (IOException e)
        {
            System.out.println("Error  during in serialization "+e);
        }

        try(ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("/C:/tmp/serial20_10_09")))
        {
            //Solution loadSolution = new Solution();
           // List<Solution> edges = new LinkedList<>();
            //loadSolution.edges=(LinkedList)objIStrm.readObject();
            solution1.edges=(LinkedList)objIStrm.readObject();

            System.out.println("---loadSolution after deserialization---");
            for(int k=0;k<solution1.edges.size();k++)
                System.out.println("loadSolution "+k+" = "+solution1.edges.get(k));
            System.out.println("---loadSolution after deserialization---");

        }catch (Exception e)
        {
            System.out.println("Error during deserialization "+e);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

       // in.close();
    }
}
