public class Main {
    public static void main(String[] args) {
        Analyst analyst = new Analyst();
        Coding coding = new Coding();
        Breathing breathing = new Breathing();

        Shell shell = new Shell();
        shell.addCommand(analyst);
        shell.addCommand(coding);
        shell.addCommand(coding);
        shell.addCommand(breathing);

        shell.excuteCommands();

    }
}
