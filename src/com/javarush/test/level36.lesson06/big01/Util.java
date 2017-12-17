package JavaRushHomeWork.src.com.javarush.test.level36.lesson06.big01;

import com.javarush.test.level36.lesson04.big01.bean.User;

public final class Util {
    public static final String DELETED_MARKER = " (deleted)";

    public static boolean isUserDeleted(JavaRushHomeWork.src.com.javarush.test.level36.lesson06.big01.bean.User user) {
        return user.getName().endsWith(DELETED_MARKER);
    }

    public static void markDeleted(JavaRushHomeWork.src.com.javarush.test.level36.lesson06.big01.bean.User user) {
        if (User.NULL_USER != user && !Util.isUserDeleted(user)) {
            user.setName(user.getName() + DELETED_MARKER);
        }
    }
}
