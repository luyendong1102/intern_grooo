public class SimpleDev extends AbstractDev{

    public SimpleDev(String name) {
        super.name = name;
    }

    @Override
    public void code() {
        System.out.println("CODING");
    }

    @Override
    public void breath() {
        System.out.println("BREAthing");
    }
}
