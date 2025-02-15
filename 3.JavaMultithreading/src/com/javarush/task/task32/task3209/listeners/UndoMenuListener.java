package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }
    public void menuSelected(MenuEvent menuEvent){
        if (view.canUndo() == true)
            undoMenuItem.setEnabled(true);
        else
            undoMenuItem.setEnabled(false);

        if (view.canRedo() == true)
            redoMenuItem.setEnabled(true);
        else
            redoMenuItem.setEnabled(false);
    }


    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
