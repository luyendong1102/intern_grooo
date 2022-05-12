public class JavDev extends Dev{

    public JavDev(String name) {
        super.name = name;
        super.skill = "JAVA";
    }

    @Override
    public void doStaff() {
        System.out.println("CODING " + skill);
    }

    @Override
    public void meeting() {
        System.out.println("MEETING AT JAVA ROOM");
    }
}
