package com.peterland.karate.api.screenplay.tasks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

public class KarateVars implements Task {
    public static String REQUEST_BODY_KARATE_VARIABLE="pretty_body";
    public static String RESPONSE_KARATE_VARIABLE="pretty_response";
    public String title;
    public String response;
    public String body;
    public Map<String, Object> vars;
    public Script script;
    public static KarateVars karateVars;

    public static KarateVars setVars(String title, Map<String, Object> vars) {
        loaded().title = title;
        loaded().vars = vars;
        loaded().response = toCompressFormat(vars.get(RESPONSE_KARATE_VARIABLE).toString());
        loaded().body = toCompressFormat(vars.get(REQUEST_BODY_KARATE_VARIABLE).toString());
        return loaded();
    }

    public static Map<String, Object> update(String key, Object object) {
        KarateVars.loaded().vars.put(key, object);
        return loaded().vars;
    }

    public static void setScript(Script script) {
        loaded();
        karateVars.script = script;
    }

    //    @Step("#title \n| RESPONSE |\n| #response |\n| BODY |\n| #body |")
    @Step("#title \n| BODY | RESPONSE |\n| #body | #response |")
    public <T extends Actor> void performAs(T actor) {

    }

    public static KarateVars loaded() {
        if (karateVars == null) {
            karateVars = new KarateVars();
        }
        return karateVars;
    }

    public static KarateVars reset() {
        karateVars = new KarateVars();
        return karateVars;
    }

    public KarateVars() {
        this.vars = new HashMap<String, Object>();
        this.response = "";
        this.karateVars = this;
    }

    public static String toPrettyFormat(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    public static String toCompressFormat(String jsonString) {
        return jsonString.replace("\n", "").replace("|", "¢");
    }
}
