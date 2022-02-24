import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.util.Date;

@Slf4j
public class Client extends Thread{

    private final String URL = "localhost";
    private final int PORT = 8080;

    @Override
    public void run() {
        try {
            while (true) {
                // wait for server to start
                // interval 2 second
                sleep(2000);

                log.info("CLIENT IS CONNECTING TO : " + URL + ":" + PORT);
                Socket clientSocket = new Socket(URL, PORT);
                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream();
                log.info("CLIENT CONNECTED TO : " + URL + ":" + PORT);


                // send data
                String time = "\r" + "Time : " + new Date().getTime() + "\n";
                out.write(time.getBytes());
                out.flush();
                log.info( "DATA SENT: " + time);

                // recieve data
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String result = bufferedReader.readLine();
                log.info("RECIEVED: " + result);

                in.close();
                out.close();
                clientSocket.close();
            }
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
