import java.util.List;

public class NameFilter implements Criteria{

    // loc ra chuoi co doi dai > 5
    @Override
    public List<Employee> filter(List<Employee> employees) {
        return employees.stream().filter(
                em -> {
                    return em.getName().length() > 5;
                }
        ).toList();
    }
}
