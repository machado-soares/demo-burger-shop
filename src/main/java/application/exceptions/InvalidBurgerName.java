package application.exceptions;

public class InvalidBurgerName extends Throwable {
    public InvalidBurgerName() {
        super();
    }

    public InvalidBurgerName(String message) {
        super(message);
    }

    public InvalidBurgerName(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBurgerName(Throwable cause) {
        super(cause);
    }
}
