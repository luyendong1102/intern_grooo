package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HtmlParser {
    public static String parse(String fileName) throws FileNotFoundException {
        String path = fileName + ".html";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String result;
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            result = scanner.nextLine();
            sb.append(result);
        }
        return sb.toString();
    }
}
