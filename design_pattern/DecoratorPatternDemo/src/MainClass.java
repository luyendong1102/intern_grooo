public class MainClass {
    public static void main(String[] args) {
        Employee em = new SuperDev(new Dev());
        Employee hr = new SuperHr(new HR());
        em.doSth();
        hr.doSth();
    }
}
