public class MainClass {

    public static void main(String[] args) {
        EmployeeFactory staffManFactory = new StaffManagerFactory();
        EmployeeFactory staffFactory = new StaffFactory();

        Employee Director = staffManFactory.getEmployee("Director");
        Director.breath();

        Employee hR = staffFactory.getEmployee("HR");

    }

}
