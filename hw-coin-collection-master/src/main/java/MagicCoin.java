import java.util.Random;

/**
 * MagicCoin class
 * @author pthakkar7
 */
public class MagicCoin extends Coin {

    private static Random rand = new Random();

    /**
     * Creates a new MagicCoin with given value and year.
     * @param value the given value
     * @param year the given year
     */
    public MagicCoin(int value, int year) {
        super(value, year);
    }

    /**
     * Creates a new MagicCoin with a given year and a random value.
     * @param year the given year
     */
    public MagicCoin(int year) {
        this(rand.nextInt(75) + 26, year);
    }

    @Override
    public String toString() {
        return "MagicCoin: " + getValue() + " " + getYear();
    }
}
