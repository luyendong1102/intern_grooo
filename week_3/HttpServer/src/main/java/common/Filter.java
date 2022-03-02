package common;

import exceptions.FobiddenException;
import http.RequestInfo;

import java.io.IOException;
import java.io.OutputStream;

public interface Filter {
    // output stream to write response when exception was caught, not optimized
    void doFilter(RequestInfo request, OutputStream out) throws IOException, FobiddenException;
}
