package com.peterland.karate.api.screenplay.questions;

import com.peterland.karate.api.screenplay.facts.ARequest;
import net.serenitybdd.screenplay.Question;


public class Response {
    public static Question<Boolean> matchesWithTheExpectedResponse() {
        return new ResponseMatches(ARequest.loaded().resource());
    }

    public static Question<Boolean> isEqualsToTheExpectedResponse() {
        return new ResponseIsEquals(ARequest.loaded().resource());
    }
}
