import java.time.LocalDate;

/**
 * CreditCard class represents a PaymentMethod, is an extension of Card.
 * CreditCard has a unique attribute that is its expiration date.
 * @author pthakkar7
 */
public class CreditCard extends Card {

    private LocalDate expirationDate;

    /**
     * Creates a new credit card with attributes ownerName, balance, and
     * expiration date.
     * @param ownerName this is the name of the owner of the credit card.
     * @param balance this is the amount of funds the credit card has.
     * @param expirationDate this is the date the card expires.
     */
    public CreditCard(String ownerName, double balance,
                      LocalDate expirationDate) {
        super(ownerName, balance);
        this.expirationDate = expirationDate;
    }

    /**
     * Checks if the card has expired, if it has, then throws a
     * CardExpiredException.
     * Otherwise, pays the given amount if possible, throws a
     * NotEnoughFundsException if there isn't enough balance.
     * @param  amount                 Amount of money to pay.
     * @throws PaymentFailedException Thrown if something goes wrong.
     */
    public void pay(double amount) throws PaymentFailedException {
        if (expirationDate.isAfter(LocalDate.now())) {
            super.pay(amount);
        } else {
            throw new CardExpiredException(expirationDate);
        }
    }
}
