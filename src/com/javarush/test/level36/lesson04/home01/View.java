package com.javarush.test.level36.lesson04.home01;

/**
 * Created by nik on 14.11.17.
 */
public class View {

    private Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());

    }
}
