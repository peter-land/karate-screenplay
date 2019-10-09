package co.peterland.karate.api.screenplay.tasks;

public enum StaticResource implements Resource {
    DATA("DATA"),
    ALL("");

    private final String text;

    StaticResource(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }

    @Override
    public Resource staticResource() {
        return this;
    }
}
