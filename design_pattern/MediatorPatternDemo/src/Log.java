public class Log {
    private String className;
    private Log (String className) {
        this.className = className;
    }

    public static Log getLogger (Class<?> clazz) {
        return new Log(clazz.getName());
    }

    public void debug(Object context) {
        System.out.println("[" + className + "] DEBUG :: " + context.toString());
    }


    public void info(Object context) {
        System.out.println("[" + className + "] INFO :: " + context.toString());
    }
}
