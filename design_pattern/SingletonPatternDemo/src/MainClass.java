public class MainClass {

    public static void main(String[] args) {

        Developer dev = Developer.getInstance();
        dev.breath();

        Director.getInstance().breath();

    }

}
