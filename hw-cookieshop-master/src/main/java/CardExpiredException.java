import java.time.LocalDate;

/**
 * CardExpiredException gets thrown when a card that is expired is used.
 *
 * @author pthakkar7
 */
public class CardExpiredException extends PaymentFailedException {

    /**
     * Creates a new CardExpiredException with the given message.
     * @param expireDate the date the card expired.
     */
    public CardExpiredException(LocalDate expireDate) {
        super("Can't Pay! Card expired on " + expireDate);
    }
}
