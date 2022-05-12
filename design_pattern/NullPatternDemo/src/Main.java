public class Main {
    public static void main(String[] args) {
        AbstractDev dev1 = DevFactory.genDev("name");
        dev1.breath();

        AbstractDev dev2 = DevFactory.genDev("nam2");
        dev2.breath();
    }
}
