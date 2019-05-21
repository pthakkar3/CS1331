/**
 * Dime class
 *
 * @author pthakkar7
 */
public class Dime extends Coin {

    /**
     * Creates a new Dime with value 10 and year given.
     * @param year The year the dime was made.
     */
    public Dime(int year) {
        super(10, year);
    }

    @Override
    public String toString() {
        return "Dime: " + getValue() + " " + getYear();
    }
}
