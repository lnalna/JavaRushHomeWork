package com.javarush.test.level23.lesson04.home01;

import java.util.List;
import java.util.Map;


/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public static void main(String[] args)
    {

    }

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();//return FAKE_TASKS_CRITERIA;
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();//return FAKE_NAMES_CRITERIA;
        nameDataProvider.refreshAllData(nameCriteria);

    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    private class TaskDataProvider implements DbDataProvider
    {
        public void refreshAllData(Map criteria)
        {
            Solution.this.tasks=DbMock.getFakeTasks(criteria);
        }
    }

    private class NameDataProvider implements DbDataProvider
    {
        public void refreshAllData(Map criteria)
        {
            Solution.this.names=DbMock.getFakeNames(criteria);
        }
    }

    class Task {
    }
}
