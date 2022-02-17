public class StaffFactory implements EmployeeFactory{
    @Override
    public Employee getEmployee(String employee) {
        if (employee.equals("Developer")) {
            return new Developer();
        }
        if (employee.equals("HR")) {
            return new HR();
        }
        return null;
    }
}
