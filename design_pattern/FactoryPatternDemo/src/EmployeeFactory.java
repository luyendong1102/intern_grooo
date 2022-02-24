public class EmployeeFactory {

    public Employee getEmployee(String employee) {
        if (employee.equals("Developer")) {
            return new Developer();
        }
        if (employee.equals("Director")) {
            return new Director();
        }
        if (employee.equals("HR")) {
            return new HR();
        }
        if (employee.equals("Manager")) {
            return new Manager();
        }
        return null;
    }

}
