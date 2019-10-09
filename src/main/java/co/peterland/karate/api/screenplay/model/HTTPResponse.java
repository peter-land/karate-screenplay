package co.peterland.karate.api.screenplay.model;

import co.peterland.karate.api.screenplay.tasks.KarateVars;

import static co.peterland.karate.api.screenplay.model.Variables.*;
import static org.apache.http.HttpStatus.SC_OK;

public class HTTPResponse {

    private Integer statusCode;
    private String body;

    public HTTPResponse(Integer statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public HTTPResponse() {
    }

    public int statusCode() {
        return statusCode;
    }

    public HTTPResponse withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String body() {
        return body;
    }

    public HTTPResponse withBody(String body) {
        this.body = body;
        return this;
    }

    public void setResponse(HTTPResponse HTTPResponse) {
        this.statusCode = HTTPResponse.statusCode;
        this.body= HTTPResponse.body;
    }

    public void updateKarateVars() {
        if (statusCode != null) KarateVars.update(STATUS_CODE_KEY, statusCode);
        if (body != null) setBodyKarateVars(body);
    }

    public static void setBodyKarateVars(String body) {
        if (isFile(body))
            KarateVars.update(RESPONSE_FILE, body);
        else
            KarateVars.update(RESPONSE_BODY, body);
    }

    public static boolean isFile(String data) {
        return !data.matches("^[\\{|\\[].*");
    }

    public static HTTPResponse successWithBody(String body){
        return new HTTPResponse(SC_OK,body);
    }

}
