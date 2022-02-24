package socket;

import common.ResponseHander;
import common.Router;
import exceptions.NotFoundException;
import http.HttpParser;
import http.RequestInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Slf4j
public class RequestHandler extends Thread{

    private InputStream in = null;
    private OutputStream out = null;
    private final Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            String content;
            // get request information
            RequestInfo request = HttpParser.parse(in);
            String key = request.getMethod() + " " + request.getPath();

            if (!Router.getInstance().containsKey(key)) {
                throw new NotFoundException(out);
            }

            ResponseHander handler = Router.getInstance().get(key);
            content = handler.doResponse(request);

            String breakLine = "\n\r";
            String response =
                            "HTTP/1.1 200 OK" + breakLine +
                                    breakLine +
                            content +
                                    breakLine;
            out.write(response.getBytes());


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
