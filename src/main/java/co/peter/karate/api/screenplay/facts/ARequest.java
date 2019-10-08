package co.peter.karate.api.screenplay.facts;

import co.peter.karate.api.screenplay.model.HTTPRequest;
import co.peter.karate.api.screenplay.tasks.Resource;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

import static co.peter.karate.api.screenplay.model.Variables.REQUEST_PATH;
import static co.peter.karate.api.screenplay.tasks.KarateVars.update;

public class ARequest implements Fact {

    public static ARequest aRequest;
    private HTTPRequest HTTPRequest;

    public ARequest() {
    }

    public static Fact to(Resource resource) {
        setResource(resource);
        return aRequest;
    }


    public static ARequest loaded() {
        if (aRequest == null) {
            aRequest = new ARequest();
            aRequest.HTTPRequest = new HTTPRequest();
        }
        return aRequest;
    }

    public Resource resource() {
        return HTTPRequest.resource();
    }

    public static void setResource(Resource resource) {
        loaded().HTTPRequest.toResource(resource);
        updateKarateVars();
    }

    public static void updateKarateVars() {
        if (loaded().resource() != null) update(REQUEST_PATH, loaded().resource().text());
    }

    @Override
    public void setup(Actor actor) {
    }
}
