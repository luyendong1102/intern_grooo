import common.Router;
import controllers.Base64;
import lombok.extern.slf4j.Slf4j;
import socket.SocketListener;

@Slf4j
public class HttpServer {

    public static void main(String[] args) {

        // setup path
        Base64 b64 = new Base64();
        b64.addToRouter();

        log.info("" + Router.getInstance().size());

        SocketListener socketListener = new SocketListener(8080);
        socketListener.run();
    }

}
