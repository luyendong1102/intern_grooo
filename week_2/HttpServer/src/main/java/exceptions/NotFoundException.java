package exceptions;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;

@Data
public class NotFoundException extends Exception {

    private final String message =
            "<html>" +
                "<body>" +
                    "<h1>URL NOT FOUND</h1>" +
                "</body>" +
            "</html>";

    public NotFoundException(OutputStream out) throws IOException {
        final String breakLine = "\n\r";
        String response =
                "HTTP/1.1 200 OK" + breakLine + // Status Line  :   HTTTP_VERSION RESPONSE_CODE RESPONSE_MESSAGE
                        "message-Length: " + message.length() + breakLine + // HEADER
                        breakLine +
                        message +
                        breakLine;
        out.write(response.getBytes());
    }

}
