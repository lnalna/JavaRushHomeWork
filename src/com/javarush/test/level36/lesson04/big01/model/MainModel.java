package JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.model.*;
import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.model.ModelData;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

/**
 * Created by nik on 17.12.17.
 */
public class MainModel implements Model
{
    private UserService userService = new UserServiceImpl();

    private ModelData modelData = new ModelData();


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(userService.getUsersBetweenLevels(1,100));
    }
}
