package co.com.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ObtenerMunicipioQuestion implements Question<String> {

    private final String systemValue;

    public ObtenerMunicipioQuestion(String systemValue) {
        this.systemValue = systemValue;
    }

    @Override
    public String answeredBy(Actor actor) {
        return systemValue;
    }
}
