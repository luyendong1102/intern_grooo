public abstract class EmployeeDecorator implements Employee {

    protected Employee decoratedWindow;



    EmployeeDecorator(Employee e) {
        this.decoratedWindow = e;
    }

}
