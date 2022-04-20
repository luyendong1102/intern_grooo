import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InterpreterEngine {
    private static Set<Expression> expressions;
    public static void handleQuery (String input) {
        if (expressions == null) {
            expressions = new HashSet<>();
            expressions.add(new SelectExpression());
            expressions.add(new WhereExpression());
        }

        expressions.forEach(
                expression -> {
                    String[] function = expression.interpret(input);
                    if (function == null) {
                        return;
                    }
                    System.out.println(function[0] + " :: " + function[1]);
                }
        );


    }

}
