package com.javarush.task.task23.task2303;

/* 
Запрети создание экземпляров класса
*/
public class Solution {

    public abstract static class Listener {
        private void onMouseDown(final int x, final int y) {
            //do something on mouse down event
        }

        private Listener() {
        }

        private void onMouseUp(final int x, final int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}
