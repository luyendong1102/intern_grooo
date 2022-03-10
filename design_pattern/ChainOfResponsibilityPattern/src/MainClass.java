public class MainClass {
    public static void main(String[] args) {
        Staff director = new Director(Staff.DIRECTOR);
        Staff manager = new Manager(Staff.MANAGER);
        Staff employee = new Employee(Staff.STAFF);

        director.setNextLevel(manager);

        manager.setNextLevel(employee);

        employee.doSth(Staff.DIRECTOR);

        director.doSth(Staff.STAFF);

    }
}
