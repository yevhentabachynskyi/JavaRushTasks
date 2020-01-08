package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by XPMUser on 10/29/18.
 */
public class BotClient extends Client {
    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws Exception {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) throws ParseException {
            ConsoleHelper.writeMessage(message);
            if (message != null && message.contains(":")) {

                String[] s = message.split(": ");
                String name = s[0];
                String text = s[1];

                if (text.equals("дата"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime())));

                else if (text.equals("день"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("d").format(Calendar.getInstance().getTime())));

                else if (text.equals("месяц"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime())));

                else if (text.equals("год"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime())));

                else if (text.equals("время"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime())));

                else if (text.equals("час"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("H").format(Calendar.getInstance().getTime())));

                else if (text.equals("минуты"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("m").format(Calendar.getInstance().getTime())));

                else if (text.equals("секунды"))
                    sendTextMessage("Информация для " + name + ": " + (new SimpleDateFormat("s").format(Calendar.getInstance().getTime())));
            }
        }
    }

    @Override
    protected String getUserName() throws Exception {
        String userName = "date_bot_"+(int) (Math.random()*100);
        return userName;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected  SocketThread getSocketThread() {
        return new BotSocketThread();
    }


    public static void main(String[] args) throws Exception {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
