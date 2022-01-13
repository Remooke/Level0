import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features/ins.feature"},

        glue = {"Steps"},plugin = {"util.AllureReporter"})

//чтобы запустить через мавен в command line прописываем: clean -Denvironment=environment install

public class CucumberRunner {
}
