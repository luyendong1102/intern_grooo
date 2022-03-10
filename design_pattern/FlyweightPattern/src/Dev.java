public class Dev implements Staff{

    private String name;

    public Dev(String name) {
        this.name = name;
    }

    @Override
    public void breath() {
        System.out.println("BREATHING");
    }
}
