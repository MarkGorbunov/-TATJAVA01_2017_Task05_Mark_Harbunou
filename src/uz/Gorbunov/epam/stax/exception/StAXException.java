package uz.Gorbunov.epam.stax.exception;

/**
 * Created by Gorbunov on 21.02.2017.
 */
public class StAXException extends  Exception {
    public StAXException() {
        super();
    }

    public StAXException(String message) {
        super(message);
    }

    public StAXException(String message, Exception e) {
        super(message, e);
    }

    public StAXException(Exception e) {
        super(e);
    }
}
