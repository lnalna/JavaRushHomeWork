package JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.controller;

import JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.model.Model;
import JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.view.UsersView;

/**
 * Created by nik on 10.12.17.
 */
public class Controller {
    private Model model;
    private UsersView usersView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }
}
