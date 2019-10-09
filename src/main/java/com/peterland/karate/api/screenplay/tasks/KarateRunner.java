package com.peterland.karate.api.screenplay.tasks;

import com.peterland.karate.api.screenplay.facts.ARequest;
import com.intuit.karate.Runner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class KarateRunner implements Task {

    private String title;
    private String featurePath;
    private Map<String, Object> vars;
    private boolean evalKarateConfig;
    private boolean printResponse;
    private static String serviceBaseURL;
    private static String DEFAULT_PARAMETER = "responseTime";

    @Step("#title")
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> result = Runner.runFeature(featurePath, vars, evalKarateConfig);
        if (printResponse)
            actor.wasAbleTo(KarateVars.setVars(getTitleLevelB(), result));
    }

    public static Map<String, Object> performAsAnonymous(Script script) {
        KarateRunner karateRunner = run(script);
        Map<String, Object> result = Runner.runFeature(karateRunner.featurePath, karateRunner.vars, karateRunner.evalKarateConfig);
        if (karateRunner.printResponse)
            KarateVars.setVars(getTitleLevelB(), result);
        return result;
    }

    public static KarateRunner run(Script script) {
        KarateVars.setScript(script);
        ARequest.to(script.resource());
        return instrumented(KarateRunner.class, getTitle(script), script.path(), KarateVars.loaded().vars, script.print());
    }

    public static KarateRunner run(Script script, Resource resource) {
        KarateVars.setScript(script);
        ARequest.to(resource);
        return instrumented(KarateRunner.class, getTitle(script, resource), script.path(), KarateVars.loaded().vars, script.print());
    }

    public KarateRunner(String title, String featurePath, Map<String, Object> vars, boolean printResponse) {
        this.title = title;
        this.featurePath = featurePath;
        this.vars = vars;
        this.evalKarateConfig = !vars.containsKey(DEFAULT_PARAMETER) ? true : false;
        this.printResponse = printResponse;
    }

    public static String getTitle(Script script) {
        return getTitle(script, script.resource());
    }

    public static String getTitle(Script script, Resource resource) {
        return "{0} executes a " + script.operation().text() + " on the resource " + resource.text();
    }

    public static String getTitleLevelB() {
        return KarateVars.loaded().script.operation().text() + " " + KarateRunner.serviceBaseURL + KarateVars.loaded().script.resource().text();
    }

    public static void setServiceBaseURL(String serviceBaseURL) {
        KarateRunner.serviceBaseURL = serviceBaseURL;
    }

}
