/**
 * Item class represents an item, having name, weight, price, and barcode.
 *
 * @author dmeyer31
 * @author pthakkar7
 */
public class Cookie {

    private String name;
    private double idNumber;
    private double price;

    /**
     * Creates a new item with the specified identification number. Initializes
     * name as null and price as 0.0.
     * @param  idNumber The identification number of the product.
     */
    public Cookie(double idNumber) {
        this(null, idNumber, 0.0);
    }

    /**
     * Create new item with the specified properties.
     * @param  name    The name of the item.
     * @param  price   The price of the item in USD.
     * @param  idNumber The identification number of the item.
     */
    public Cookie(String name, double idNumber, double price) {
        this.name = name;
        this.idNumber = idNumber;
        this.price = price;
    }

    /**
     * Returns the price of a cookie.
     * @return the price of the cookie;
     */
    public double getPrice() {
        return price;
    }

    /**
     * Compares the equality of two items based on their name and id.
     * @param  other the item(object) to be compared
     * @return a boolean value giving the equality of the two objects;
     */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cookie)) {
            return false;
        }
        Cookie that = (Cookie) other;
        return this.name.equals(that.name) && this.idNumber == that.idNumber;
    }
}
