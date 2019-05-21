import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * A CoinBook which you store all the collected Coins.
 *
 * @author pthakkar7
 */
public class CoinBook {

    /**
     * A class to compare coins by their year, then value and then state(if it
     * is a quarter).
     */
    static class YearComparator implements Comparator<Coin> {

        /**
         * Method that compares two coins.
         * @param a The first coin
         * @param b The second coin
         * @return a value that is either positive, negative, or zero that
         * determines the comparison between the coins
         */
        public int compare(Coin a, Coin b) {
            int counter = 0;
            if (a.getYear() > b.getYear()) {
                counter = 1;
            }
            if (a.getYear() < b.getYear()) {
                counter = -1;
            }
            if (a.getYear() == b.getYear()) {
                counter = a.getValue() - b.getValue();
                if (counter == 0 && a instanceof Quarter
                                                     && b instanceof Quarter) {
                    Quarter one = (Quarter) a;
                    Quarter two = (Quarter) b;
                    counter = one.getState().compareTo(two.getState());
                }
            }
            return counter;
        }
    }

    private Set<Coin> coinBook;

    /**
     * Creates a new CoinBook that is a MySet
     */
    public CoinBook() {
        coinBook = new MySet<>();
    }

    /**
     * Adds a coin to the coinbook.
     * @param c The coin to be added
     * @return whether or not the coin was successfully added
     */
    public boolean addCoin(Coin c) {
        if (coinBook.add(c)) {
            return true;
        }
        return false;
    }

    /**
     * Removes a coin from the coinbook.
     * @param c The coin to be removed
     * @return whether or not the coin was successfully removed
     */
    public boolean removeCoin(Coin c) {
        if (coinBook.remove(c)) {
            return true;
        }
        return false;
    }

    /**
     * Sorts the coins in the coinbook based on their value
     * @return a list of coins that is sorted by value.
     */
    public List<Coin> sortByValue() {
        List<Coin> val = new ArrayList<>();
        for (Coin c : coinBook) {
            val.add(c);
        }
        Collections.sort(val);
        return val;
    }

    /**
     * Sorts the coins in the coinbook based on their year
     * @return a list of coins that is sorted by year.
     */
    public List<Coin> sortByYear() {
        List<Coin> sortYear = new ArrayList<>();
        for (Coin c : coinBook) {
            sortYear.add(c);
        }
        Collections.sort(sortYear, new YearComparator());
        return sortYear;
    }

    /**
     * Gives a String representation of all the coins in the coinbook.
     * @return a String output of all the coins in the coinbook.
     */
    public String toString() {
        String coins = "";
        for (Coin c: coinBook) {
            coins = coins + c.toString() + " ";
        }
        return coins;
    }
}
