/**
 * Abstract Coin class.
 *
 * @author pthakkar7
 * @version 1.0
 */
public abstract class Coin implements Comparable<Coin> {

    private int value;
    private int year;

    /**
     * Creates a new Coin with given value and year.
     * @param value the given value
     * @param year the given year
     */
    public Coin(int value, int year) {
        this.value = value;
        this.year = year;
    }

    /**
     * Method for getting the value of a coin
     * @return the value of the coin
     */
    public int getValue() {
        return value;
    }

    /**
     * Method for getting the year of a coin
     * @return the year of the coin
     */
    public int getYear() {
        return year;
    }

    /**
     * Method that gives the String representation of the coin
     * @return the String output of the coin
     */
    public String toString() {
        return "Coin: " + value + " " + year;
    }

    @Override
    public int compareTo(Coin other) {
        int counter = 0;
        if (this.value > other.value) {
            counter = 1;
        }
        if (this.value < other.value) {
            counter = -1;
        }
        if (this.value == other.value) {
            counter = this.year - other.year;
        }
        return counter;
    }

    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Coin)) {
            return false;
        }
        Coin that = (Coin) other;
        return this.value == that.value && this.year == that.year;
    }

    // This method should not be modified
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + year;
        hash = 31 * hash + value;
        return hash;
    }

}
