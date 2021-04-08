package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = {"@Rob3"},
        glue = {"Steps"},
        plugin =
                "pretty"
        ,
        //strict = true,dryRun = true
        monochrome = true)
public class RunnerTest {
}
