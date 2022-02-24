package controllers;

import com.google.gson.Gson;
import common.Router;
import entities.Message;
import http.RequestInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Base64 implements Controller{

    // POST "/"
    private String base64encode (RequestInfo request) {
        log.info(request.getContent());
        Gson gson = new Gson();
        Message message = gson.fromJson(request.getContent(), Message.class);
        return java.util.Base64.getEncoder().encodeToString(message.getBase64().getBytes());
    }

    // GET "/"
    private String hello (RequestInfo request) {
        return  "<html>" +
                "<body>" +
                "<h1>hElL0 hUM4n</h1>" +
                "</body>" +
                "</html>";
    }

    @Override
    public void addToRouter() {
        RequestInfo info = new RequestInfo();
        // base 64 post
        info.setMethod("POST");
        info.setPath("/");
        Router.getInstance().put(info.getMethod() + " " + info.getPath(), this::base64encode);

        // HELLO
        info.setMethod("GET");
        info.setPath("/");
        Router.getInstance().put(info.getMethod() + " " + info.getPath(), this::hello);
    }

}
