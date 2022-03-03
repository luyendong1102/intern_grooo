import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int age;
    private List<Employee> team = new ArrayList<>();
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public void setTeam(List<Employee> team) {
        this.team = team;
    }
}
