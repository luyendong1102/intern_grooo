public class DevProxy implements Staff{

    private Dev dev;

    public DevProxy(Dev dev) {
        this.dev = dev;
    }

    @Override
    public void breath() {
        dev.breath();
        System.out.println("ASDAS PROXY HERE");
    }
}
