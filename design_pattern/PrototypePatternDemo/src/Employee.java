public abstract class Employee implements Cloneable{
    protected String name;
    protected Employee(String name) {
        this.name = name;
    }
    public abstract void breath();
    public abstract String getName();

    @Override
    public Employee clone() {
        try {
            Employee clone = (Employee) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
