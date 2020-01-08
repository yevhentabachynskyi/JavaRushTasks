package com.javarush.task.task36.task3601;



import java.util.List;

/**
 * Created by XPMUser on 6/1/19.
 */
public class Controller {
   private Model model = new Model();
    public List<String> onShowDataList() {
        return model.getStringDataList();
    }
}
