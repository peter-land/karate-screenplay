package com.peterland.karate.api.screenplay.tasks;

import static com.peterland.karate.api.screenplay.tasks.BaseOperation.TRANSFORM_DATA;
import static com.peterland.karate.api.screenplay.tasks.BaseOperation.VALIDATE_RESPONSE;
import static com.peterland.karate.api.screenplay.tasks.StaticResource.ALL;
import static com.peterland.karate.api.screenplay.tasks.StaticResource.DATA;


public enum BaseScript implements Script {
    GET(BaseOperation.GET, ALL, "classpath:com/peterland/karate/api/model/templates/get/get_path/get_path.feature", true),
    POST(BaseOperation.POST, ALL, "classpath:com/peterland/karate/api/model/templates/post/post_path/post_path.feature", true),
    POST_AUTHORIZED(BaseOperation.POST, ALL, "classpath:com/peterland/karate/api/model/templates/post/post_path_authorized/post_path_authorized.feature", true),
    GET_AUTHORIZED(BaseOperation.GET, ALL, "classpath:com/peterland/karate/api/model/templates/get/get_path_authorized/get_path_authorized.feature", true),
    MATCHER(VALIDATE_RESPONSE, ALL, "classpath:com/peterland/karate/api/model/templates/validate/validate_matcher/validate_matcher.feature", false),
    VERIFY_RESPONSE(VALIDATE_RESPONSE, ALL, "classpath:com/peterland/karate/api/model/templates/validate/validate_response/validate_response.feature", false),
    MERGE_JSON(TRANSFORM_DATA, DATA, "classpath:com/peterland/karate/api/model/templates/data/json/data_json_combine.feature", false);

    private final String path;
    private final Operation operation;
    private final Resource resource;
    private final Boolean print;

    BaseScript(Operation operation, Resource resource, String path, Boolean print) {
        this.path = path;
        this.operation = operation;
        this.resource = resource;
        this.print = print;
    }

    public String path() {
        return path;
    }

    public Operation operation() {
        return operation;
    }

    public Resource resource() {
        return resource;
    }

    public Boolean print() {
        return print;
    }
}
