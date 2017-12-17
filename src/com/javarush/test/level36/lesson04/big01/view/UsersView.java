package JavaRushHomeWork.src.com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;
import com.javarush.test.level36.lesson04.big01.view.*;
import com.javarush.test.level36.lesson04.big01.view.View;

/**
 * Created by nik on 10.12.17.
 */
public class UsersView implements View
{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All users:");

        for(User user: modelData.getUsers()) {
            System.out.println("\t" + user);
        }

        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
}
