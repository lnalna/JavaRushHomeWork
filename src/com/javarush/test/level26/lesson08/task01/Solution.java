package com.javarush.test.level26.lesson08.task01;

/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
public class Solution {

    public static class IntegerHolder{

        private int  temp_var=0;


        public synchronized void set(int temp_var)
        {
            this.temp_var=temp_var;
        }
        public synchronized int get()
        {
            return temp_var;
        }
    }

    public static void main(String[] args) {
    }
}
