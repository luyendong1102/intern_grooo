package common;

import java.util.Map;
import java.util.Set;

public interface Parser {
    String parse(String input);
    Map<String, Object> parseMap(String input);
}
