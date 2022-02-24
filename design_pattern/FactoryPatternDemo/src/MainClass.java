public class MainClass {

    public static void main(String[] args) {
        EmployeeFactory fe = new EmployeeFactory();
        Employee HR = fe.getEmployee("HR");
        HR.breath();

        Employee Manager = fe.getEmployee("Manager");
        Manager.breath();
    }

}
