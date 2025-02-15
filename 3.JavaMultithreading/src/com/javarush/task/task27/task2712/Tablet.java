package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by XPMUser on 1/21/19.
 */
public class Tablet extends Observable {
    final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order= new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                try {
                    AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime());
                    advertisementManager.processVideos();
                } catch (NoVideoAvailableException e) {
                    logger.log(Level.INFO,"No video is available for the order " + order);
                }
                setChanged();
                notifyObservers(order);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
        return order;
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);

    }
}
