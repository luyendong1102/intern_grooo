public class Director extends Staff{

    public Director(int level) {
        this.level = level;
    }

    @Override
    protected void dodo() {
        System.out.println("DIRECTOR THINGS");
    }
}
