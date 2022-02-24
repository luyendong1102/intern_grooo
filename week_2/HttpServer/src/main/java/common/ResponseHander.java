package common;

import http.RequestInfo;

public interface ResponseHander {
    String doResponse(RequestInfo request);
}
