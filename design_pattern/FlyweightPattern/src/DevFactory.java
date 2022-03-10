import java.util.HashMap;
import java.util.Map;

public class DevFactory {
    private static final Map<String, Dev> devContainer = new HashMap<>();

    public static Dev getDev (String name) {
        Dev dev = devContainer.get(name);
        if (dev == null) {
            dev = new Dev(name);
            devContainer.put(name, dev);
        }
        return dev;
    }

}
