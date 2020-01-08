package com.javarush.task.task30.task3008.client;

import java.text.ParseException;

/**
 * Created by XPMUser on 11/8/18.
 */
public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public class GuiSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) throws ParseException {
           model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    protected int getServerPort() throws Exception {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() throws Exception {
        return view.getUserName();
    }

    @Override
    protected String getServerAddress() throws Exception {
        return view.getServerAddress();
    }

    @Override
    public void run() throws Exception {
        getSocketThread().run();
    }
    public ClientGuiModel getModel(){
     return model;
    }

    public static void main(String[] args) throws Exception {
        ClientGuiController guiController = new ClientGuiController();
        guiController.run();
    }
}
