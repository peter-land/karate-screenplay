package starter.commons;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KarateRunnerTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void run() {
        List<String> tags = Arrays.asList("~@karate");
        List<String> features = Arrays.asList("classpath:features/karate/load_url.feature");
        KarateRunner karateRunner=new KarateRunner(tags,features,1);
        karateRunner.run();
    }

    @Test
    public void nonExistentClasspath() {
        List<String> tags = Arrays.asList("~@karate");
        List<String> features = Arrays.asList("classpath:features/karate/non-existent.feature");
        KarateRunner karateRunner=new KarateRunner(tags,features,1);
        exceptionRule.expect(AssertionError.class);
        karateRunner.run();
    }
}
