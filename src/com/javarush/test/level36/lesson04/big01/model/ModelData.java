package JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.model;

import JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 10.12.17.
 */
public class ModelData {
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
