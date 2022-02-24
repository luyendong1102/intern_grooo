import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        List<Employee> data = new ArrayList<Employee>();
        data.add(new Employee("ASDASD", "Male", "Dev"));
        data.add(new Employee("ASDASD", "Male", "Devf"));
        data.add(new Employee("ASDAsdSD", "fMale", "Dev"));
        data.add(new Employee("ASDASasdD", "fMale", "Dev"));
        data.add(new Employee("ASasd", "Male", "Dev"));
        data.add(new Employee("asd", "fMale", "Devf"));
        data.add(new Employee("ASD", "Male", "Devf"));

        Criteria sexFilter = new SexFilter();
        Criteria nameFilter = new NameFilter();

        sexFilter.filter(data).forEach(System.out::println);
        System.out.println("------------------------------");
        nameFilter.filter(data).forEach(System.out::println);

    }

}
