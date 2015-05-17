package ro.adc.hra.base;

public class ServiceTechnicalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceTechnicalException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ServiceTechnicalException(final String message) {
        super(message);
    }

}
