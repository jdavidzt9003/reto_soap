package co.com.test.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/feature/obtenermunicipio.feature"},
        glue = {"co.com.test.stepdefinition"}
)
public class ObtenerMunicipioRunner {
}
