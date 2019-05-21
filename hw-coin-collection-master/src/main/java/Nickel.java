/**
 * Nickel class
 *
 * @author pthakkar7
 */
public class Nickel extends Coin {

    /**
     * Creates a new Nickel with value 5 and year given.
     * @param year The year the nickel was made.
     */
    public Nickel(int year) {
        super(5, year);
    }

    @Override
    public String toString() {
        return "Nickel: " + getValue() + " " + getYear();
    }
}
