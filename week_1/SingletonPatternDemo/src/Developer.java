public class Developer implements Employee{

    private static Developer instance;

    @Override
    public void breath() {
        System.out.println("ouch ouch");
    }

    public static Developer getInstance() {
        if (instance == null) {
            return new Developer();
        }
        return instance;
    }

}
