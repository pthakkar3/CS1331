/**
 * Quarter class
 * @author pthakkar7
 */
public class Quarter extends Coin {

    private State state;

    /**
     * Creates a new Quarter with value 25 and a given year and state.
     * @param year The year the quarter was made.
     * @param state The state of the quarter.
     */
    public Quarter(int year, State state) {
        super(25, year);
        this.state = state;
    }

    /**
     * Method for getting the state of the quarter.
     * @return the state of the quarter.
     */
    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Quarter: " + getValue() + " " + getYear() + " " + state;
    }

    @Override
    public int compareTo(Coin other) {
        if (other instanceof Quarter) {
            Quarter that = (Quarter) other;
            int counter = this.state.compareTo(that.state);
            if (counter == 0) {
                counter = this.getYear() - that.getYear();
            }
            return counter;
        }
        return super.compareTo(other);
    }

    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Quarter)) {
            return false;
        }
        Quarter that = (Quarter) other;
        return this.getYear() == that.getYear() && this.state == that.state;
    }
}
