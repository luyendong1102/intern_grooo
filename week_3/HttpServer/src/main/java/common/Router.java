package common;

import http.RequestInfo;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private static Map<String, ResponseHander> pathContainer;

    public static Map<String, ResponseHander> getInstance() {
        if (pathContainer == null) {
            pathContainer = new HashMap<>();
            return pathContainer;
        }
        return pathContainer;
    }

}
