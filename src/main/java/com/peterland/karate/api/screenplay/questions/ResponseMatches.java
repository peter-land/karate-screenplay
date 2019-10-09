package com.peterland.karate.api.screenplay.questions;

import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import com.peterland.karate.api.screenplay.tasks.Resource;
import com.peterland.karate.api.screenplay.tasks.BaseScript;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the response matches with the expected response")
public class ResponseMatches implements Question<Boolean> {

    public Resource resource;

    public ResponseMatches(Resource resource) {
        this.resource = resource;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(KarateRunner.run(BaseScript.MATCHER, resource));
        return true;
    }
}
