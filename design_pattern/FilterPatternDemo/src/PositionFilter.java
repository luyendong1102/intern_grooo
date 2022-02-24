import java.util.List;

public class PositionFilter implements Criteria{
    @Override
    public List<Employee> filter(List<Employee> employees) {
        return employees.stream().filter(
                em -> {
                    return em.getPosition().equals("Dev");
                }
        ).toList();
    }
}
