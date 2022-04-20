import java.util.HashMap;
import java.util.Map;

public class WhereExpression implements Expression{

    @Override
    public String[] interpret(String input) {
        String[] function = new String[2];

        if (input.contains("where")) {
            function[0] = "where";
            function[1] = "where constrain";
            return function;
        }

        return null;
    }
}
