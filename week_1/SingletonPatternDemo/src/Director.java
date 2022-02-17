public class Director implements Employee{

    private static Director instance;

    public static Director getInstance() {
        if (instance == null) {
            return new Director();
        }
        return instance;
    }

    @Override
    public void breath() {
        System.out.println("Breatthinggg ....");
    }
}
