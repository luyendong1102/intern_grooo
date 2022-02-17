public class MainClass {

    public static void main(String[] args) {
        Employee e = new EmployeeBuilder().setName("Steve").isDeveloper().build();
        System.out.println(e.getName());
    }

}
