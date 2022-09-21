package co.com.test.exceptions;

public class FailedCodeStatus extends AssertionError{

    public static final String THE_RESPONSE_FAILED = "Responde failed, mistake code";

    public FailedCodeStatus(String message, Throwable cause){
        super(message, cause);
    }
}
