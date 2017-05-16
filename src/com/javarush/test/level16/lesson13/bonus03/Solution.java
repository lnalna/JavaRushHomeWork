package com.javarush.test.level16.lesson13.bonus03;

/* Отдебажим все на свете
Разобраться, что делает програма.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)

Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message
*/

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();
       threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler) {
            setDefaultUncaughtExceptionHandler(handler);// было setUncaughtExceptionHandler(handler);
            start();

            /*Существует три способа установки обработчика необрабатываемых ошибок.
             Первое, вы можете вызвать метод setUncaughtExceptionHandler() класса Thread.
            Его вызов позволяет настроить поведение обработчика для выбранного потока.
            Второе, вы можете создать объект ThreadGroup и изменять поведение всех потоков в группе
            переопределив метод uncaughtException().
            Третье, вы можете установить поведение по умолчанию для всех потоков вызвав
             статический метод setDefaultUncaughtExceptionHandler() класса Thread.
              */
        }

        public void run() {
            try {

                Thread.sleep(3000);
            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());

                   }
    }
}
