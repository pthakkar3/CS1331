/**
 * NotEnoughFundsException gets thrown when a payment is attempted from a
 * PaymentMethod that does not have enough funds.
 *
 * @author pthakkar7
 */
public class NotEnoughFundsException extends PaymentFailedException {

    /**
     * Creates a new NotEnoughFundsException with the given message.
     * @param msg The message of the exception.
     */
    public NotEnoughFundsException(String msg) {
        super(msg);
    }
}
