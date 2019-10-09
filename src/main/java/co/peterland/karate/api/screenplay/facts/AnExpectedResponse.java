package co.peterland.karate.api.screenplay.facts;

import co.peterland.karate.api.screenplay.model.HTTPResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

public class AnExpectedResponse implements Fact {

    public static AnExpectedResponse anExpectedResponse;
    private co.peterland.karate.api.screenplay.model.HTTPResponse HTTPResponse;

    public AnExpectedResponse() {
    }

    public static Fact withStatusCode(int statusCode) {
        setStatusCode(statusCode);
        return anExpectedResponse;
    }

    public static Fact withBody(String body) {
        setBody(body);
        return anExpectedResponse;
    }

    public static Fact equalsTo(HTTPResponse HTTPResponse) {
        setResponse(HTTPResponse);
        return anExpectedResponse;
    }

    public static AnExpectedResponse loaded() {
        if (anExpectedResponse == null) {
            anExpectedResponse = new AnExpectedResponse();
            anExpectedResponse.HTTPResponse = new HTTPResponse();
        }
        return anExpectedResponse;
    }

    public static void setStatusCode(int statusCode) {
        loaded().HTTPResponse.withStatusCode(statusCode);
    }

    public static void setBody(String body) {
        loaded().HTTPResponse.withBody(body);
    }

    public static void setResponse(HTTPResponse HTTPResponse) {
        loaded().HTTPResponse.setResponse(HTTPResponse);
        loaded().HTTPResponse.updateKarateVars();
    }

    @Override
    public void setup(Actor actor) {
    }
}
