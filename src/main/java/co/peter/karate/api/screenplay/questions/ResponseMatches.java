package co.peter.karate.api.screenplay.questions;

import co.peter.karate.api.screenplay.tasks.KarateRunner;
import co.peter.karate.api.screenplay.tasks.Resource;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.peter.karate.api.screenplay.tasks.BaseScript.MATCHER;

@Subject("the response matches with the expected response")
public class ResponseMatches implements Question<Boolean> {

    public Resource resource;

    public ResponseMatches(Resource resource) {
        this.resource = resource;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(KarateRunner.run(MATCHER, resource));
        return true;
    }
}
