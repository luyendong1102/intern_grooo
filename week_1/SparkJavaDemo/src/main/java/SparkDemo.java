import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

import static spark.Spark.*;

@Slf4j
public class SparkDemo {

    public static void main(String[] args) {

        port(1102);

        // post method request
        post("/base64", (req, res) -> {
            Gson gson = new Gson();

            Message msg = gson.fromJson(req.body(), Message.class);

            msg = base64encode(msg);

            // set return type
            res.type("application/json");
            return gson.toJson(msg);
        });

        // exception handler
        exception(Exception.class, (err, req, res) -> {
            res.status(400);
            res.body(err.getMessage());
        });

    }

    static private Message base64encode(Message msg) {
        msg.setAsdasd(
                Base64.getEncoder().encodeToString(
                        msg.getAsdasd().getBytes()));
        msg.setAaaaaaaa(
                Base64.getEncoder().encodeToString(
                        msg.getAaaaaaaa().getBytes()));
        msg.setQqqqqqqqq(
                Base64.getEncoder().encodeToString(
                        msg.getQqqqqqqqq().getBytes()));
        return msg;
    }

}
