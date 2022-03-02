package common;

import java.util.HashMap;
import java.util.Map;

public class PostRequestParser implements Parser{
    @Override
    public String parse(String input) {
        return null;
    }

    @Override
    public Map<String, Object> parseMap(String input) {
        Map<String, Object> result = new HashMap<String, Object>();
        for (String context : input.split("&")) {
            String[] parseRes = context.split("=");
            result.put(parseRes[0], parseRes[1]);
        }
        return result;
    }
}
