package socket;

import common.*;
import exceptions.NotFoundException;
import http.RequestInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.util.Base64;
import java.util.UUID;

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

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            // handle http request
            String content;
            String sessionID = null;
            RequestInfo request = HttpParser.parse(bufferedReader);
            String key = request.getMethod() + " " + request.getPath();

            log.info(key + " accessed");

            // router checking
            if (!Router.getInstance().containsKey(key)) {
                throw new NotFoundException(out);
            }

            if (!key.equals("GET /") && !key.equals("POST /")){
                log.info("not default gateway");
                Filter logins = new LoginFilter();
                logins.doFilter(request, out);
            }

            log.info(request.getMethod() + " " + request.getPath() + " connected");
            if (request.getSessionID() == null || request.getSessionID().equals("")) {
                sessionID = UUID.randomUUID().toString();
            }
            // handle request depend on path
            ResponseHander handler = Router.getInstance().get(key);
            content = handler.doResponse(request);

            String breakLine = "\n\r";
            // http properties
            // new request will get new cookie that contain session id
            String response =
                            "HTTP/1.1 200 OK" +
                                    breakLine +
                                    // header
                                    (sessionID == null ? "" : "Set-Cookie: " + sessionID + "\n") +
                                    "Content-Length: " + content.length() +
                                    breakLine +
                                    breakLine +
                                    // content
                                    content +
                                    breakLine;
            out.write(response.getBytes());
            out.flush();

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
