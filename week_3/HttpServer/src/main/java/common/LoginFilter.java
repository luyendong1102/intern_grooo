package common;

import exceptions.FobiddenException;
import http.RequestInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;

@Slf4j
public class LoginFilter implements Filter{
    @Override
    public void doFilter(RequestInfo request, OutputStream out) throws IOException, FobiddenException {
        String sessionID = request.getSessionID();
        log.info(sessionID);
        if (request.getSessionID() == null || request.getSessionID().equals("")) {
            throw new FobiddenException(out);
        }
        if (!SessionManager.getInstance().containsKey(request.getSessionID())) {
            throw new FobiddenException(out);
        }
    }
}
