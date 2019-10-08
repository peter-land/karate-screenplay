package co.peter.karate.api.screenplay.tasks;

public class DynamicResource implements Resource {

    private Resource staticResource;
    private String dynamicPath;

    public DynamicResource(Resource staticResource, String dynamicPath) {
        this.staticResource = staticResource;
        this.dynamicPath = dynamicPath;
    }

    @Override
    public String text() {
        return staticResource.text() + "/" + dynamicPath;
    }

    @Override
    public Resource staticResource() {
        return staticResource;
    }
}
