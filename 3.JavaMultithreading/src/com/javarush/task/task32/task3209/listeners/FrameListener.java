package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by XPMUser on 12/25/18.
 */
public class FrameListener extends WindowAdapter {
private View view;

    public FrameListener(View view) {
        this.view = view;
    }
    public void windowClosing(WindowEvent windowEvent){
        view.exit();
    }
}
