package co.peterland.karate.api.screenplay.tasks;

public interface Script {
    String path();
    Operation operation();
    Resource resource();
    Boolean print();
}
