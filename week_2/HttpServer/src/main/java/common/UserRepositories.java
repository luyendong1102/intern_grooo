package common;

import java.util.ArrayList;
import java.util.List;

public class UserRepositories {
    private static List<User> userData;

    public static List<User> getInstance() {
        if (userData == null) {
            userData = new ArrayList<>();
            return userData;
        }
        return userData;
    }

}
