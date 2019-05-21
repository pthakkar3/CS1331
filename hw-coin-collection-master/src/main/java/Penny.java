/**
 * Penny class
 *
 * @author pthakkar7
 */
public class Penny extends Coin {

    /**
     * Creates a new Penny with value 1 and year given.
     * @param year The year the penny was made.
     */
    public Penny(int year) {
        super(1, year);
    }

    @Override
    public String toString() {
        return "Penny: " + getValue() + " " + getYear();
    }
}
