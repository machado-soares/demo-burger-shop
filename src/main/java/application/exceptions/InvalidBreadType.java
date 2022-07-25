package application.exceptions;

public class InvalidBreadType extends Throwable {
    public InvalidBreadType() {
        super();
    }

    public InvalidBreadType(String message) {
        super(message);
    }

    public InvalidBreadType(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBreadType(Throwable cause) {
        super(cause);
    }
}
