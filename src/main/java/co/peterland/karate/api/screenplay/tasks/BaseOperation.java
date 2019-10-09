package co.peterland.karate.api.screenplay.tasks;

public enum BaseOperation implements Operation{
    GET("GET"),
    POST("POST"),
    CONFIGURE_MOCK("CONFIGURE MOCK"),
    TRANSFORM_DATA("TRANSFORM DATA"),
    VALIDATE_SCHEMA("VALIDATE SCHEMA"),
    VALIDATE_RESPONSE("VALIDATE RESPONSE");

    private final String text;

    BaseOperation(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
