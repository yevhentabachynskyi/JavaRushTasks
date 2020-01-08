package com.javarush.task.task23.task2304;
import java.util.*;
/* 
Inner 3
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }
    private class TaskDataProvider implements DbDataProvider{

        @Override
        public void refreshAllData(Map criteria) {
            tasks = new DbMock().getFakeTasks(criteria);

        }
    }
    private class NameDataProvider implements DbDataProvider{

        @Override
        public void refreshAllData(Map criteria) {
           names = new DbMock().getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {

    }
}
