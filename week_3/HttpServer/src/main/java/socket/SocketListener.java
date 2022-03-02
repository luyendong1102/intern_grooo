package socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class SocketListener{

    private ServerSocket serverSocket;
    private int port;

    public SocketListener(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run () {
        log.info("Server is running at port : " + port );
        while (serverSocket.isBound() && !serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                // handle request
                Thread requestHander = new RequestHandler(socket);
                requestHander.start();
            }
            catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

}
