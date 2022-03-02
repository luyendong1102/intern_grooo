package http;

import lombok.Data;

import java.util.Objects;

@Data
public class RequestInfo {
    private String method;
    private String path;
    private String content;
    private String header;
    private String sessionID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestInfo that = (RequestInfo) o;
        return this.method.equals(((RequestInfo) o).getMethod()) && this.path.equals(((RequestInfo) o).getPath());
    }

}
