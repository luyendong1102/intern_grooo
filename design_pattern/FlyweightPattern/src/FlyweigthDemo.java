public class FlyweigthDemo {
    public static void main(String[] args) {
        Dev dev = new Dev("ASD");
        Dev dev2 = new Dev("AAS");
        Dev asd = new Dev("AAA");

        DevFactory.getDev("ASD").breath();

        DevFactory.getDev("AAA").breath();

    }
}
