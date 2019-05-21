/**
 * Card class represents a PaymentMethod, cannot be instantiated.
 * Card has attributes ownerName and balance.
 * @author pthakkar7
 */
public abstract class Card implements PaymentMethod {

    private String ownerName;
    private double balance;

    /**
     * Creates a new card with attributes ownerName and balance.
     * @param ownerName this is the name of the owner of the card.
     * @param balance this is the amount of funds the card has.
     */
    public Card(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * Pays the given amount if possible, throws a NotEnoughFundsException if
     * there isn't enough balance.
     * @param  amount                 Amount of money to pay.
     * @throws PaymentFailedException Thrown if something goes wrong.
     */
    public void pay(double amount) throws PaymentFailedException {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            throw new NotEnoughFundsException(
                                    "There aren't enough funds on this Card!");
        }
    }
}
