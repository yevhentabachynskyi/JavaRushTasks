package com.javarush.task.task24.task2403;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.RemoteObject;
import java.util.EventListener;
import java.util.ArrayDeque;

/* 
Так-с... сопоставим
*/
public class Solution {
    public static class A implements Serializable {
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B implements Remote {
        protected final B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }

    }

    public static class C extends ArrayDeque implements Cloneable{
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener {
        protected D clone() throws CloneNotSupportedException {
            return (D) super.clone();
        }
    }


    public static void main(String[] args) {

    }
}
