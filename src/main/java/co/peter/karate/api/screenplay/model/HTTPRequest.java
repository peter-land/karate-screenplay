package co.peter.karate.api.screenplay.model;

import co.peter.karate.api.screenplay.tasks.Resource;

import static co.peter.karate.api.screenplay.model.Variables.*;
import static co.peter.karate.api.screenplay.tasks.KarateVars.update;

public class HTTPRequest {

    private Resource resource;
    private String body;

    public HTTPRequest(Resource resource, String body) {
        this.resource = resource;
        this.body = body;
    }

    public HTTPRequest() {
    }

    public Resource resource() {
        return resource;
    }

    public HTTPRequest toResource(Resource resource) {
        this.resource = resource;
        return this;
    }

    public String body() {
        return body;
    }

    public HTTPRequest withBody(String body) {
        this.body = body;
        return this;
    }

    public void setResponse(HTTPRequest HTTPRequest) {
        this.resource = HTTPRequest.resource;
        this.body= HTTPRequest.body;
    }

    public void updateKarateVars() {
        if (resource != null) update(REQUEST_PATH, resource.text());
        if (body != null) setBodyKarateVars(body);
    }

    public static void setBodyKarateVars(String body) {
        if (isFile(body))
            update(REQUEST_FILE, body);
        else
            update(REQUEST_BODY, body);
    }

    public static boolean isFile(String data) {
        return !data.matches("^[\\{|\\[].*");
    }

}
