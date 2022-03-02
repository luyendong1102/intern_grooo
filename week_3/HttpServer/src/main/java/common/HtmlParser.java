package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class HtmlParser implements Parser{
    public String parse(String fileName) {
        String path = fileName + ".html";
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            String result;
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                result = scanner.nextLine();
                sb.append(result);
            }
            return sb.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> parseMap(String input) {
        return null;
    }
}
