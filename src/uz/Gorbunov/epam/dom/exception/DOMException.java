package uz.Gorbunov.epam.dom.exception;

/**
 * Created by Gorbunov on 21.02.2017.
 */
public class DOMException extends Exception {

    public DOMException() {
        super();
    }

    public DOMException(String message) {
        super(message);
    }

    public DOMException(String message, Exception e) {
        super(message, e);
    }

    public DOMException(Exception e) {
        super(e);
    }
}
