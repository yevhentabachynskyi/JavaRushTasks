package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPMUser on 6/1/19.
 */
public class Model {
  private Service service = new Service();
    public List<String> getStringDataList() {
        return service.getData();
    }
}
