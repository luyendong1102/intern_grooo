
import common.User;
import common.UserRepositories;
import controllers.Base64;
import lombok.extern.slf4j.Slf4j;
import socket.SocketListener;

import java.io.IOException;

@Slf4j
public class HttpServer {

    public static void main(String[] args) throws IOException {

        UserRepositories.getInstance().add(new User("admin", "1"));

        // setup path
        Base64 b64 = new Base64();
        b64.addToRouter();

/*        Client client = new Client();
        client.start();*/

        SocketListener socketListener = new SocketListener(8080);
        socketListener.run();

    }

}
