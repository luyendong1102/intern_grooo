public class Main {
    public static void main(String[] args) {
        State notKnown = Context.getState("CHANGE_PASSWORD");
        notKnown.doAction();

        notKnown = Context.getState("CHANGE_NAME");
        notKnown.doAction();
    }
}
