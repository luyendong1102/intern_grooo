public class MainClass {
    public static void main(String[] args) {
        Employee senior = new Employee("ASD", 21);
        Employee junior = new Employee("ASDA", 10);
        Employee fresher = new Employee("GADF", 5);
        senior.getTeam().add(junior);
        senior.getTeam().add(fresher);

        senior.getTeam().forEach(System.out::println);

    }
}
