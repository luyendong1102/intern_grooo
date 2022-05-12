public class Main {
    public static void main(String[] args) {
        Dev dev1 = new JavDev("ASD");
        dev1.doStaff();
        dev1.meeting();
        Dev dev = new PhpDev("AAAA");
        dev.doStaff();
        dev.meeting();
    }
}
