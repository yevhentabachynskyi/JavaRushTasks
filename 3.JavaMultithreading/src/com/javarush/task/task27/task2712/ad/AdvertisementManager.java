package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

/**
 * Created by XPMUser on 1/24/19.
 */
public class AdvertisementManager {
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos() throws NoVideoAvailableException {
      if (storage.videos.isEmpty())
          throw new NoVideoAvailableException();
    }
}
