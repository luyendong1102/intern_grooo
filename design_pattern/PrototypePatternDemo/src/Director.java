public class Director extends Employee {

    public Director(String name) {
        super(name);
    }

    @Override
    public void breath() {
        System.out.println("Breatthinggg ....");
    }

    @Override
    public String getName() {
        return super.name;
    }

}
