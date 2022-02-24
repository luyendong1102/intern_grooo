public class MainClass {
    public static void main(String[] args) {
        EmployeeCache.initData();
        Director dir = (Director) EmployeeCache.getEmployee("Tino");
        System.out.println(dir.getName());
    }
}
