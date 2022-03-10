public class ProxyPatternDemo {
    public static void main(String[] args) {
        Staff realDev = new Dev();
        realDev.breath();
        Staff dev = new DevProxy(new Dev());
        dev.breath();
    }
}
