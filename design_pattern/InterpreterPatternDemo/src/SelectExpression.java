import java.util.HashMap;
import java.util.Map;

public class SelectExpression implements Expression{

    @Override
    public String[] interpret(String input) {

        String[] function = new String[2];

        if (input.contains("select")) {
            function[0] = "select";
            function[1] = "select data from result";
            return function;
        }

        return null;
    }
}
