package com.javarush.test.level24.lesson02.home01;

/**
 * Created by admin on 02.03.15.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker

{
    public SelfInterfaceMarkerImpl()
    {
    }

    public void test()
    {
        System.out.println("Test!!!");
    }
    public String test_str()
    {
        return "test string";
    }
}
