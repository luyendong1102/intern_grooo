import java.util.List;

public class SexFilter implements Criteria{
    @Override
    public List<Employee> filter(List<Employee> employees) {
        return employees.stream().filter(
                em -> {
                    return em.getSex().equals("Male");
                }
        ).toList();
    }
}
