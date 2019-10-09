package com.peterland.karate.api.screenplay.model;

import com.peterland.karate.api.screenplay.tasks.Resource;
import com.peterland.karate.api.screenplay.tasks.KarateVars;

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
        if (resource != null) KarateVars.update(Variables.REQUEST_PATH, resource.text());
        if (body != null) setBodyKarateVars(body);
    }

    public static void setBodyKarateVars(String body) {
        if (isFile(body))
            KarateVars.update(Variables.REQUEST_FILE, body);
        else
            KarateVars.update(Variables.REQUEST_BODY, body);
    }

    public static boolean isFile(String data) {
        return !data.matches("^[\\{|\\[].*");
    }

}
