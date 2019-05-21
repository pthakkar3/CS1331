import java.time.LocalDate;
/**
 * Demo class demonstrates the function of the CheckoutPage and ensures that
 * all of the exceptions are properly thrown and handled.
 * @author pthakkar7
 */
public class Demo {
    /**
     * Calls all of the testing methods to demonstrate the functionality of the
     * exceptions.
     * @param args default parameter of main method
     */
    public static void main(String[] args) {
        System.out.println("Let's start the Demo!");
        testInvalidCookie1();
        testInvalidCookie2();
        testValidCookie1();
        testValidCookie2();
        testExpiredCreditCard();
        testLowBalanceCreditCard();
        testWorkingCreditCard();
        testLowFundsVenmo();
        testWorkingVenmo();
        System.out.println("Demo concluded!");
    }

    private static void testInvalidCookie1() {
        try {
            System.out.println("We will try adding a cookie that was given only"
                                + " one parameter to the cart:");
            CheckoutPage page1 = new CheckoutPage();
            Cookie invalid1 = new Cookie(12);
            page1.addToCart(invalid1);
            System.out.println("Valid cookie added to cart!");
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testInvalidCookie2() {
        try {
            System.out.println("Now, a cookie that has all parameters but is"
                                + " not on the menu:");
            CheckoutPage page2 = new CheckoutPage();
            Cookie invalid2 = new Cookie("blah", 320908.0, 13.0);
            page2.addToCart(invalid2);
            System.out.println("Valid cookie added to cart!");
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testValidCookie1() {
        try {
            System.out.println("Now, a cookie that is on the menu but given a"
                                  + " wrong price:");
            CheckoutPage page3 = new CheckoutPage();
            Cookie valid1 = new Cookie("Mixed Bundle", 12, 13);
            page3.addToCart(valid1);
            System.out.println("Valid cookie added to cart!");
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testValidCookie2() {
        try {
            System.out.println("Now, a cookie that is on the menu:");
            CheckoutPage page4 = new CheckoutPage();
            Cookie valid2 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page4.addToCart(valid2);
            System.out.println("Valid cookie added to cart!");
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testExpiredCreditCard() {
        try {
            System.out.println("Let's try to pay with an expired CreditCard:");
            CheckoutPage page5 = new CheckoutPage();
            Cookie cookie1 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page5.addToCart(cookie1);
            Cookie cookie2 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page5.addToCart(cookie2);
            CreditCard expired = new CreditCard("Me", 120.00,
                                                 LocalDate.parse("2016-02-20"));
            page5.payForCart(expired);
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testLowBalanceCreditCard() {
        try {
            System.out.println("Let's try to pay with a card with low funds:");
            CheckoutPage page6 = new CheckoutPage();
            Cookie cookie3 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page6.addToCart(cookie3);
            Cookie cookie4 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page6.addToCart(cookie4);
            CreditCard lowFunds = new CreditCard("Me", 20.00,
                                                 LocalDate.parse("2017-02-20"));
            page6.payForCart(lowFunds);
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testWorkingCreditCard() {
        try {
            System.out.println("Let's try to pay with a working CreditCard:");
            CheckoutPage page7 = new CheckoutPage();
            Cookie cookie5 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page7.addToCart(cookie5);
            Cookie cookie6 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page7.addToCart(cookie6);
            CreditCard working = new CreditCard("Me", 1200.00,
                                                 LocalDate.parse("2017-02-20"));
            page7.payForCart(working);
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testLowFundsVenmo() {
        try {
            System.out.println("Let's try to pay with a Venmo with low funds:");
            CheckoutPage page8 = new CheckoutPage();
            Cookie cookie7 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page8.addToCart(cookie7);
            Cookie cookie8 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page8.addToCart(cookie8);
            Venmo lowFunds = new Venmo("pthakkar3", "password", 20.00);
            page8.payForCart(lowFunds);
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testWorkingVenmo() {
        try {
            System.out.println("Let's try to pay with a working Venmo:");
            CheckoutPage page9 = new CheckoutPage();
            Cookie cookie9 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page9.addToCart(cookie9);
            Cookie cookie10 = new Cookie("BigWich Deluxe", 7777777, 12.99);
            page9.addToCart(cookie10);
            Venmo working = new Venmo("pthakkar3", "password", 1120.00);
            page9.payForCart(working);
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
