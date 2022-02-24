package socket;

import common.ResponseHander;
import common.Router;
import exceptions.NotFoundException;
import http.HttpParser;
import http.RequestInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.util.Base64;

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
            // limit data to reset
            bufferedReader.mark(10000);
            int _byte = bufferedReader.read();
            // reset after checking fisrt byte
            bufferedReader.reset();

            // handle non http request
            if (_byte == 13) {
                StringBuilder stringBuilder = new StringBuilder();
                while (_byte != 10) {
                    stringBuilder.append((char) _byte);
                    _byte = bufferedReader.read();
                }
                String base64 = Base64.getEncoder().encodeToString(stringBuilder.toString().getBytes());
                log.info("FROM SERVER: " + base64);
                out.write(base64.getBytes());
                out.flush();
                return;
            }

            // handle http request
            String content;
            RequestInfo request = HttpParser.parse(bufferedReader);
            String key = request.getMethod() + " " + request.getPath();

            // router checking
            if (!Router.getInstance().containsKey(key)) {
                throw new NotFoundException(out);
            }

            log.info(request.getMethod() + " " + request.getPath() + " connected");

            // handle request depend on path
            ResponseHander handler = Router.getInstance().get(key);
            content = handler.doResponse(request);

            String breakLine = "\n\r";

            // http properties
            String response =
                            "HTTP/1.1 200 OK" + breakLine +
                                    breakLine +
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
