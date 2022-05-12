public class DevFactory {

    private static final String[] names = {"name", "name1", "name2"};

    public static AbstractDev genDev (String name) {
        for (String s : names) {
            if (s.equals(name)) {
                return new SimpleDev(s);
            }
        }
        return new NullDev(name);
    }

}
