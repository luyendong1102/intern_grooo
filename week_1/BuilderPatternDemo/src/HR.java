public class HR extends Employee{
    public HR(String name) {
        super(name);
    }

    @Override
    public void breath() {
        System.out.println("hmmmm");
    }

    @Override
    public String getName() {
        return super.name;
    }

}
