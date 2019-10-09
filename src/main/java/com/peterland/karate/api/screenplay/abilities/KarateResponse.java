package com.peterland.karate.api.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;

public class KarateResponse implements Ability  {
    private String response;

    public KarateResponse(String response) {
        this.response = response;
    }

    public String toString() {
        return "Validate response: " + this.response;
    }

    public static KarateResponse validate(String response){
        return new KarateResponse(response);
    }
}
