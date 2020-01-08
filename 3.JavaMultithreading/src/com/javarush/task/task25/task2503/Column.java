package com.javarush.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer") {
        @Override
        public String getColumnName() {
            return null;
        }

        @Override
        public boolean isShown() {
            return false;
        }

        @Override
        public void hide() {

        }
    },
    BankName("Bank Name") {
        @Override
        public String getColumnName() {
            return null;
        }

        @Override
        public boolean isShown() {
            return false;
        }

        @Override
        public void hide() {

        }
    },
    AccountNumber("Account Number") {
        @Override
        public String getColumnName() {
            return null;
        }

        @Override
        public boolean isShown() {
            return false;
        }

        @Override
        public void hide() {

        }
    },
    Amount("Available Amount") {
        @Override
        public String getColumnName() {
            return null;
        }

        @Override
        public boolean isShown() {
            return false;
        }

        @Override
        public void hide() {

        }
    };

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        for (Column column : Column.values())
//        Column[] column = Column.values();
//        for (int i = 0; i < realOrder.length-1; i++)
        result.add(column);
        return result;
    }
}
