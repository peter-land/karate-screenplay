package starter.commons;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KarateRunnerTest {

    @Test
    public void run() {
        List<String> tags = Arrays.asList("~@karate");
        List<String> features = Arrays.asList("classpath:features/karate/load_url.feature");
        KarateRunner karateRunner=new KarateRunner(tags,features,1);
        karateRunner.run();
    }
}
