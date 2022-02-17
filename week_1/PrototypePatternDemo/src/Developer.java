public class Developer extends Employee {


    protected Developer(String name) {
        super(name);
    }

    @Override
    public void breath() {
        System.out.println("ouch ouch");
    }

    @Override
    public String getName() {
        return super.name;
    }
}
