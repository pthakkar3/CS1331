/**
 * Venmo class represents a PaymentMethod.
 * Venmo has attributes username, password, and balance;
 * @author pthakkar7
 */
public class Venmo implements PaymentMethod {

    private String username;
    private String password;
    private double balance;

    /**
     * Creates an instance of a Venmo account with attributes username,
     * password, and balance.
     * @param username the username of the account
     * @param password the account's password
     * @param balance the amount of funds in the account
     */
    public Venmo(String username, String password, double balance) {
        this.username = username;
        this.password = password;
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
                            "There aren't enough funds on this Venmo account!");
        }
    }
}
