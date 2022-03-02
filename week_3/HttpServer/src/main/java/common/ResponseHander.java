package common;

import http.RequestInfo;

import java.io.FileNotFoundException;

public interface ResponseHander {
    String doResponse(RequestInfo request) throws FileNotFoundException;
}
