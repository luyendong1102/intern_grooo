public class StaffManagerFactory implements EmployeeFactory{
    @Override
    public Employee getEmployee(String employee) {
        if (employee.equals("Director")) {
            return new Director();
        }
        if (employee.equals("Manager")) {
            return new Manager();
        }
        return null;
    }
}
