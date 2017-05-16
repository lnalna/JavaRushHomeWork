package com.javarush.test.level28.lesson06.home01;


/**
 * Created by admin on 14.04.15.
 */
public class MyThread extends Thread
{
   static  int i=Thread.MIN_PRIORITY;

    public MyThread()
    {
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())i=Thread.MIN_PRIORITY;

    }

    public MyThread(Runnable target)
    {
        super(target);
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())i=Thread.MIN_PRIORITY;
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())i=Thread.MIN_PRIORITY;
    }

    public MyThread(String name)
    {
        super(name);
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())i=Thread.MIN_PRIORITY;
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())
            i=Thread.MIN_PRIORITY;

    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())i=Thread.MIN_PRIORITY;
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())i=Thread.MIN_PRIORITY;
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        this.setPriority(i++);
        if (i>Thread.currentThread().getThreadGroup().getMaxPriority())i=Thread.MIN_PRIORITY;
    }
}
