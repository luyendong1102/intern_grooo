public class PhpDev extends Dev{

    public PhpDev(String name) {
        super.name = name;
        skill = "PHP";
    }

    @Override
    public void doStaff() {
        System.out.println(name + " coding " + skill);
    }

    @Override
    public void meeting() {
        System.out.println(name + " metting " + skill);
    }
}
