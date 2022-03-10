public abstract class Staff {
    public static final int DIRECTOR = 3;
    public static final int MANAGER = 2;
    public static final int STAFF = 1;

    protected int level;

    protected Staff nextChain;

    public void setNextLevel(Staff nextChain) {
        this.nextChain = nextChain;
    }

    public void doSth(int level) {
        if (level <= this.level) {
            dodo();
        }
        if (nextChain != null) {
            nextChain.doSth(level);
        }
    }

    abstract protected void dodo();

}
