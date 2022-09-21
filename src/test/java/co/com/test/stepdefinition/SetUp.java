package co.com.test.stepdefinition;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class SetUp {

    protected static final String URL_BASE = "http://ovc.catastro.meh.es";
    protected static final String RESOURCE = "/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx";

    protected Actor actor;

    private void setUpActor() {
        actor = Actor.named("Automated");
    }

    private void setUpActorAndApi() {
        actor.can(CallAnApi.at(URL_BASE));
    }

    protected void setUp() {
        setUpActor();
        setUpActorAndApi();
    }

    protected HashMap<String, Object> headers() {
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "text/xml;charset=UTF-8");
        headersCollection.put("SOAPAction", "http://tempuri.org/OVCServWeb/OVCCallejero/ConsultaMunicipio");
        return headersCollection;
    }

    protected String fromLastResponseBy(Actor actor) {
        return new String(LastResponse.received().answeredBy(actor).asByteArray(),
                StandardCharsets.UTF_8
        );
    }
}
