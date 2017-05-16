package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {

    class Clock implements Runnable
    {
        public void run()
        {
            Thread current = Thread.currentThread();

            while(!current.isInterrupted())
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Tik");
            }
        }
    }

    public static void processThreads(Thread... threads)
    {
        for (Thread currentThread : threads) {

            switch (currentThread.getState())
            {
                case NEW:// если нить не запущена, то запускаем ее
                    currentThread.start();
                    break;
                case RUNNABLE: // если нить работает, то проверяем маркер isInterrupted
                    currentThread.isInterrupted();
                    break;
                case BLOCKED:// если нить в ожидании, то прерываем ее
                    currentThread.interrupt();
                    break;
                case WAITING:// если нить в ожидании, то прерываем ее
                    currentThread.interrupt();
                    break;
                case TIMED_WAITING:// если нить в ожидании, то прерываем ее
                    currentThread.interrupt();
                    break;
                case TERMINATED://Если нить прекратила работу, то выведите в консоль ее приоритет.
                    System.out.println(currentThread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Clock clock = solution.new Clock();

        Thread clockThread  = new Thread(clock);

        processThreads(clockThread);
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        clockThread.interrupt();

        processThreads(clockThread);
    }
}
