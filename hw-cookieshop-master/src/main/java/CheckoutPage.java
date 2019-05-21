import java.util.ArrayList;

/**
 * The CheckoutPage class has attributes validCookies(a list of valid cookies),
 * cart(represents the cookies the customer intends to buy), and totalPrice(the
 * total price of the cookies in the cart).
 * @author pthakkar7
 */
public class CheckoutPage {

    private ArrayList<Cookie> validCookies;
    private ArrayList<Cookie> cart;
    private double totalPrice;

    /**
     * Creates a new checkout page that initializes validCookies with the
     * getValidCookies method from server, and initializes cart as a new
     * ArrayList instance. May throw a ServerException.
     */
    public CheckoutPage() {
        boolean val = true;
        while (val) {
            try {
                validCookies = Server.getValidCookies();
                val = false;
            } catch (ServerException e) {
                val = true;
            }
        }
        cart = new ArrayList<Cookie>();
    }

    /**
     * Adds a new cookie to the cart, but only if it is a valid cookie.
     * Otherwise, it throws an InvalidCookieException.
     * @param cookie The cookie to be added to the cart.
     * @throws InvalidCookieException thrown if invalid cookie added to cart.
     */
    public void addToCart(Cookie cookie) throws InvalidCookieException {
        boolean cookieInCart = false;
        for (Cookie cook : validCookies) {
          //System.out.println(cook + " " + cookie);
            if (cook.equals(cookie)) {
                cookieInCart = true;
                cart.add(cook);
            }
        }
        if (!cookieInCart) {
            throw new InvalidCookieException();
        }
    }

    /**
     * Adds the prices of the cookies in the cart and returns the total price.
     * @return totalPrice the price of all cookies in the cart.
     */
    public double getTotalPrice() {
        for (Cookie cookie : cart) {
            totalPrice = totalPrice + cookie.getPrice();
        }
        return totalPrice;
    }

    /**
     * Attempts to pay for the cookies in the cart with any payment method, and
     * empties the cart if it succeeds. It might throw a PaymentFailedException,
     * in which case the error message will be printed.
     * @param method the payment method used
     * @throws PaymentFailedException thrown if the payment fails for some
     * reason
     */
    public void payForCart(PaymentMethod method) throws PaymentFailedException {
        try {
            method.pay(getTotalPrice());
            cart.clear();
            System.out.println("Payment successful!");
        } catch (PaymentFailedException p) {
            System.out.println(p.getMessage());
        }
    }
}
