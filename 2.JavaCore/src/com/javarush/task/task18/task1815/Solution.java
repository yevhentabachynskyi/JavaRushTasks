package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        private ATableInterface tableInterface;
        public TableInterfaceWrapper (ATableInterface tableInterface){
            this.tableInterface = tableInterface;
        }

        @Override
        public void setModel(List rows) {
            tableInterface.setModel(rows);
            System.out.println(rows.size());
        }

        @Override
        public String getHeaderText() {
          return tableInterface.getHeaderText().toUpperCase();

        }

        @Override
        public void setHeaderText(String newHeaderText) {
            tableInterface.setHeaderText(newHeaderText);
    newHeaderText.toLowerCase();
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}