public class SuperHr extends EmployeeDecorator{
    SuperHr(Employee e) {
        super(e);
    }

    @Override
    public void doSth() {
        doHRMORe();
        System.out.println("aaaaaaaaaaaaaaa");
    }

    public void doHRMORe() {
        System.out.println("ASDASD");
    }

}
