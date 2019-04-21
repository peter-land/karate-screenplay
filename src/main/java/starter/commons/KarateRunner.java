package starter.commons;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class KarateRunner {

    public List<String> tags;
    public List<String> features;
    public int threads;
    public static String KARATE_OUTPUT_PATH = "target/surefire-reports";
    public static int DEFAULT_THREADS = 1;
    public static String DEFAULT_TAGS = "~@karate";

    public KarateRunner(List<String> tags, List<String> features, int threads) {
        this.tags = tags;
        this.features = features;
        this.threads = threads;
    }

    public KarateRunner(String tag, String feature, int threads) {
        this.tags = Arrays.asList(tag);
        this.features = Arrays.asList(feature);
        this.threads = threads;
    }

    public KarateRunner(String tag, String feature) {
        this.tags = Arrays.asList(tag);
        this.features = Arrays.asList(feature);
        this.threads = this.threads;
    }

    public KarateRunner(String feature) {
        this.tags = Arrays.asList("");
        this.features = Arrays.asList(feature);
        this.threads = DEFAULT_THREADS;
    }

    public void run() {
        Results results = Runner.parallel(tags, features, this.threads, KARATE_OUTPUT_PATH);
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

    public static void runFeature(String featurePath){
        List<String> tags = Arrays.asList(DEFAULT_TAGS);
        List<String> features = Arrays.asList(featurePath);
        Results results = Runner.parallel(tags, features, DEFAULT_THREADS, KARATE_OUTPUT_PATH);
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }
}
