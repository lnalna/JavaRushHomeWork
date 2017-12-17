package JavaRushHomeWork.src.com.javarush.test.level36.lesson06.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.*;
import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 10.12.17.
 */
public class FakeModel implements Model
{

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("User1", 1, 1));
        users.add(new User("User2", 2, 3));
        users.add(new User("User3", 3, 2));

        modelData.setUsers(users);
    }
}
