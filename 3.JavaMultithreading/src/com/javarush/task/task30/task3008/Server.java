package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message request = new Message(MessageType.NAME_REQUEST);
            Message response;
            String name;
            do {
                connection.send(request);
                response = connection.receive();
                name = response.getData();
            } while (response.getType() != MessageType.USER_NAME || name.isEmpty() || connectionMap.containsKey(name));
            connectionMap.put(name, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
              String name = entry.getKey();
                Message message = new Message(MessageType.USER_ADDED, name);
                if (!name.equals(userName))
                connection.send(message);
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            Message response;
            while (true){
              response = connection.receive();
              if (response.getType() == (MessageType.TEXT)){
                 sendBroadcastMessage(new Message(MessageType.TEXT,userName + ": " + response.getData()));
              }else
                  ConsoleHelper.writeMessage("Не смогли отправить сообщение");
            }
        }
        public void run(){
            String userName = null;
            ConsoleHelper.writeMessage("Connected with address " + socket.getRemoteSocketAddress());
            try {
               Connection connection = new Connection(socket);
               connection.getRemoteSocketAddress();
                ConsoleHelper.writeMessage("Ok");
               userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException e) {
                ConsoleHelper.writeMessage("соединение закрито");
            }catch (ClassNotFoundException c){
                ConsoleHelper.writeMessage("соединение закрито");
            }
            finally {

                    if (userName != null) {
                        connectionMap.remove(userName);
                        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    }
                }
            }

    }

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение");
            }
        }

    }
    public static void main(String[] args) throws Exception {
        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {

            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {
                //Слушаем
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                //запускаем handler
                handler.start();

            }

        }catch (Exception e){
            System.out.println(e);
        }


    }
}
