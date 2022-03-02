package common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SessionManager {
    private static Map<String, User> userSessions;

    // this collection only contains session id that logged in
    public static Map<String, User> getInstance() {
        if (userSessions == null) {
            userSessions = new HashMap<>();
            return userSessions;
        }
        return userSessions;
    }
}
