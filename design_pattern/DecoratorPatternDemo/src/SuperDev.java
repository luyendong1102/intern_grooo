public class SuperDev extends EmployeeDecorator{
    SuperDev(Employee e) {
        super(e);
    }

    @Override
    public void doSth() {
        doSpDev();
        super.decoratedWindow.doSth();
    }

    public void doSpDev() {
        System.out.println("DASDASD");
    }
}
