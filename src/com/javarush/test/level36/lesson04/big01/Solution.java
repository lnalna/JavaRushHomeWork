package JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01;

import JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.controller.Controller;
import JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.model.FakeModel;
import JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.model.Model;
import JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.view.UsersView;

public class Solution {
    public static void main(String[] args)
    {
        Model model = new FakeModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        usersView.fireEventShowAllUsers();
    }
}
