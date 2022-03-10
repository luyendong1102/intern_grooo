public class Employee extends Staff{

    public Employee(int level) {
        this.level = level;
    }

    @Override
    protected void dodo() {
        System.out.println("EMPLOYEE THINGS");
    }
}