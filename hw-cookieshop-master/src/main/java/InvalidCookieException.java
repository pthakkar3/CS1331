/**
 * InvalidCookieException gets thrown when a cookie that is not on the menu
 * gets added to the cart
 *
 * @author pthakkar7
 */
public class InvalidCookieException extends Exception {

    /**
     * Creates a new InvalidCookieException with a default message.
     */
    public InvalidCookieException() {
        this("This Cookie is not on our menu...");
    }

    /**
     * Creates a new InvalidCookieException with the given message.
     * @param msg The message of the exception.
     */
    public InvalidCookieException(String msg) {
        super(msg);
    }
}
