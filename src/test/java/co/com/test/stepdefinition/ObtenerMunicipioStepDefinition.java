package co.com.test.stepdefinition;

import co.com.test.exceptions.DataNullFailed;
import co.com.test.exceptions.FailedCodeStatus;
import co.com.test.questions.ObtenerMunicipioQuestion;
import co.com.test.tasks.ObtenerMunicipioTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.containsString;


public class ObtenerMunicipioStepDefinition extends SetUp {

    private static final String BODY_REQUEST = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cat=\"http://www.catastro.meh.es/\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <cat:Provincia>PONTEVEDRA</cat:Provincia>\n" +
            "      <cat:Municipio>VIGO</cat:Municipio>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

    @Given("que el automatizador ingresa una provincia y municipio")
    public void queElAutomatizadorIngresaUnaProvinciaYMunicipio() {
        setUp();
        actor.attemptsTo();
    }

    @When("el automatizador ejecuta el servicio")
    public void elAutomatizadorEjecutaElServicio() {
        actor.attemptsTo(
                new ObtenerMunicipioTask()
                        .usingThe(RESOURCE)
                        .with(headers())
                        .and(BODY_REQUEST)
        );
    }

    @Then("el servicio Obtener Municipios arroja los datos asociados al municipio")
    public void elServicioObtenerMunicipiosArrojaLosDatosAsociadosAlMunicipio() {
        actor.should(
                seeThatResponse("El código de respuesta HTTP deber ser: " + SC_OK,
                        response -> response.statusCode(SC_OK)
                ).orComplainWith(
                        FailedCodeStatus.class,
                        FailedCodeStatus.THE_RESPONSE_FAILED
                ),
                seeThat(
                        "Los datos de la respuesta deben ser: ",
                        new ObtenerMunicipioQuestion(fromLastResponseBy(actor)),
                        containsString("<muni><nm>" + "VIGO" + "</nm><locat><cd>" + 54 + "</cd><cmc>" + 57 + "</cmc></locat><loine><cp>" + 36 + "</cp><cm>" + 57 + "</cm></loine></muni>"))
                        .orComplainWith(
                                DataNullFailed.class,
                                DataNullFailed.DATA_NULL_FAILED)
        );
    }
}
