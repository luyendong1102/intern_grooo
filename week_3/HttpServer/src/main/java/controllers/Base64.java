package controllers;

import com.google.gson.Gson;
import common.*;
import entities.Message;
import http.RequestInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.util.Map;

@Slf4j
public class Base64 implements Controller{

    // POST "/"
    private String base64encode (RequestInfo request) {
        Parser parser = new PostRequestParser();
        Parser htmlParser = new HtmlParser();
        Map<String, Object> context = parser.parseMap(request.getContent());
        if (
                UserRepositories.getInstance().stream().anyMatch(
                        user -> {
                            return (context.get("username").toString().equals(user.getUsername()) &&
                            context.get("password").toString().equals(user.getPassword()));
                        }
                )
        )
        {
            // do login
            SessionManager.getInstance().put(request.getSessionID(), new User(context.get("username").toString(), context.get("password").toString()));
            log.info("USER " + context.get("username") + "LOGGED IN");
        }
        else {
            return htmlParser.parse("loginfail");
        }
        return htmlParser.parse("hello");
    }

    // GET "/"
    // handle login of user
    private String hello (RequestInfo request) throws FileNotFoundException {
        Parser parser = new HtmlParser();
        return parser.parse("index");
    }

    private String test (RequestInfo request) throws FileNotFoundException {
        Parser parser = new HtmlParser();
        return parser.parse("test");
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

        // test
        info.setMethod("GET");
        info.setPath("/test");
        Router.getInstance().put(info.getMethod() + " " + info.getPath(), this::test);
    }

}
