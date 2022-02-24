import java.util.List;

public interface Criteria {
    List<Employee> filter(List<Employee> employees);
}
