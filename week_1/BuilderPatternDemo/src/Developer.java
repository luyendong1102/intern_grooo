public class Developer extends Employee{
    public Developer(String name) {
        super(name);
    }

    @Override
    public void breath() {
        System.out.println("clicky");
    }

    @Override
    public String getName() {
        return super.name;
    }

}
