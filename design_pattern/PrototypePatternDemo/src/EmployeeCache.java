import java.util.HashMap;

public class EmployeeCache {

    private static HashMap<String, Employee> cloneData = new HashMap<>();
    public static Employee getEmployee(String key) {
        Employee e = cloneData.get(key);
        return e.clone();
    }

    public static void initData() {
        cloneData.put("Steve", new Developer("Steve"));

        cloneData.put("Job", new Developer("Job"));

        cloneData.put("Florent", new Director("Florent"));

        cloneData.put("Tino", new Director("Tino"));
    }

}
