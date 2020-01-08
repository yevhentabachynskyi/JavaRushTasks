package com.javarush.task.task36.task3601;

/**
 * Created by XPMUser on 6/1/19.
 */
public class View {
private Controller controller = new Controller();
    public void fireShowDataEvent() {
        System.out.println(controller.onShowDataList());
    }
}
