package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;


    public class SocketThread extends Thread{
       protected void processIncomingMessage(String message) throws ParseException {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + "add chat");
        }
        protected  void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + "remove chat");
        }
        protected  void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify(); }
        }
        protected void clientHandshake() throws Exception {
            Message response;
            while (true){
                response = connection.receive();
                if (response.getType() == MessageType.NAME_REQUEST){
                 String s = Client.this.getUserName();
                    Message message = new Message(MessageType.USER_NAME, s);
                    connection.send(message);
                }
                else if(response.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }

        }
        protected void clientMainLoop() throws Exception, ClassNotFoundException{
            Message response;
            while (true){
                response = connection.receive();
                if (response.getType() == MessageType.TEXT){
                    processIncomingMessage(response.getData());
                }
                else if (response.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(response.getData());
                }
                else if (response.getType() ==  MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(response.getData());
                } else {
                    throw new IOException("Unexpected MessageType");

                }
            }
        }

        public void run(){
            try {
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();
            } catch (Exception e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
    protected String getServerAddress() throws Exception {
        return ConsoleHelper.readString();
    }
    protected  int getServerPort() throws Exception {
       return ConsoleHelper.readInt();
    }
    protected  String getUserName() throws Exception {
        return  ConsoleHelper.readString();
    }
    protected  boolean shouldSendTextFromConsole(){
        return true;
    }
    protected  SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected  void sendTextMessage(String text){
        try {
        Message message = new Message(MessageType.TEXT,text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error");
            clientConnected = false;
        }
    }


    public void run() throws Exception {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            notify();
            if (clientConnected == true){
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            } else
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            while (true) {
                String str = ConsoleHelper.readString();
                if (str.equals("exit") || !clientConnected) {
                    break;
                }
                if (shouldSendTextFromConsole() == true)
                    sendTextMessage(str);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.run();
    }

}
