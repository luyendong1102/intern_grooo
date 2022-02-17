public abstract class Employee {

    protected final String name;

    protected Employee(String name) {
        this.name = name;
    }

    public abstract String getName();

    public abstract void breath();

}
