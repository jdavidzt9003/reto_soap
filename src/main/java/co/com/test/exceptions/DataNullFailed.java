package co.com.test.exceptions;

public class DataNullFailed extends AssertionError {

    public static final String DATA_NULL_FAILED = "La consulta arrojo la data fallida o nula";

    public DataNullFailed(String message, Throwable cause){
        super(message, cause);
    }
}
