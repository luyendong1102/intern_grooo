public class RandomTask {

    private Employee employee;
    private Human human;
    private Robot robot;

    void humanThings () {
        employee = new HumanEm();
        employee.work();
        human = (HumanEm)employee;
        human.breath();
    }

    void robotThings () {
        employee = new X25();
        employee.work();
        robot = (Robot) employee;
        robot.doRobotThings();
    }

}
