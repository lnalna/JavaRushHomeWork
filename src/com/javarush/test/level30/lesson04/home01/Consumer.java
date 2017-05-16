package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by admin on 16.07.15.
 */
public class Consumer implements Runnable{

    protected TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue){
        this.queue = queue;
    }

    /*
    5. Реализация метода run для Consumer:
5.1. Усыпить трэд на 0.5 секунды
5.2. В бесконечном цикле заберите элемент из очереди методом take и выведите в консоль "Processing item.toString()".
     */
    @Override
    public void run() {
        try {
            Thread currentThread = Thread.currentThread();

            while(!currentThread.isInterrupted()) {

                Thread.sleep(500);

                while (true) {
                    try {
                        System.out.println("Processing " + queue.take().toString());
                    }
                    catch (InterruptedException e) {
                            return;
                    }
                }
            }
        }catch (InterruptedException e){

        }
    }
}
