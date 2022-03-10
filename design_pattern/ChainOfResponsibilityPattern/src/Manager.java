public class Manager extends Staff{

    public Manager(int level) {
        this.level = level;
    }

    @Override
    protected void dodo() {
        System.out.println("MANAGER THINGS");
    }
}