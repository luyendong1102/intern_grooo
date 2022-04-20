public class ExpressionDemo {
    public static void main(String[] args) {
        String sql = "select * from tablle where something bla";

        InterpreterEngine.handleQuery(sql);

    }
}
