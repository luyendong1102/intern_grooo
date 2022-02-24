package http;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
@Slf4j
public class HttpParser {

    public static RequestInfo parse (InputStream inputStream) throws IOException {

        final int LF = 10; // \r
        final int CR = 13; // \n
        final int SP = 32; // space

        RequestInfo request = new RequestInfo();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();

        // get method and path
        String line = bufferedReader.readLine();
        String[] fields = line.split(" ");
        request.setMethod(fields[0]);
        request.setPath(fields[1]);

        // skip header
        int contentLength = -1;
        while (line.length() != 0) {
            if (line.contains("Content-Length")) {
                contentLength = Integer.parseInt(line.split(" ")[1]);
            }
            line = bufferedReader.readLine();
        }

        // get body content
        int data;

        // return when unnecessary
        if (contentLength == -1) {
            return request;
        }
        while (contentLength != 0) {
            data = bufferedReader.read();
            stringBuilder.append((char)data);
            contentLength --;
        }
        String content = stringBuilder.toString();
        request.setContent(content);

        return request;
    }

}
