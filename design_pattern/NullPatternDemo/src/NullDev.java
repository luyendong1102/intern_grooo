public class NullDev extends AbstractDev{

    public NullDev(String name) {
        super.name = "";
    }

    @Override
    public void code() {
        System.out.println("DO NOTHING");
    }

    @Override
    public void breath() {
        System.out.println("DO NOTHING");
    }
}
