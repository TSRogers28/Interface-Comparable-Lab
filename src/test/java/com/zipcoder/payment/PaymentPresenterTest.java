package com.zipcoder.payment;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentPresenterTest {

    //When there is no payment
    @Test
    public void noPayment() {
        Payment[] payment = new Payment[0];
        PaymentPresenter presenter = new PaymentPresenter();
        String expected = "";

        String actual = presenter.toString(payment);

        assertEquals(expected, actual);

    }


    //When there are multiple payments, you need to sort it first,
    // then build the string using the short description

    @Test
    public void sortMultiplePayments() {
        Payment[] payment = new Payment[2];
        Payment paypal = new PayPal(4L, "Tia Mowry", "tia@mowry.com");
        Payment check = new Check(81L, "Tia Mowry", "11432543", "134344551");

        payment[0] = paypal;
        payment[1] = check;

        PaymentPresenter presenter = new PaymentPresenter();
        String expected = "Check Tia Mowry ***2543\nPaypal Tia Mowry tia@mowry.com\n";

        String actual = presenter.toString(payment);
        assertEquals(expected, actual);
    }


    //Create a test case to test the toStringByPayerName method of the PaymentPresenter class
    @Test
    public void toStringByPayerName(){
        Payment[] payment = new Payment[1];
        Payment paypal = new PayPal(120L, "Tamara Mowry", "tamara@mowry.com");

        payment[0] = paypal;
        PaymentPresenter presenter = new PaymentPresenter();

        String expected = "Paypal Tamara Mowry tamara@mowry.com";
        String actual = presenter.toStringByPayerName(payment);
        assertEquals(expected, actual);

    }



    //When there are multiple payments, you need to sort by calling the PaymentSortByPayer class to sort,
    // then build the string using the short description

    @Test
    public void paymentSortByPayer() {
        Payment[] payment = new Payment[2];
        Payment paypal = new PayPal(4L, "Tamara Mowry", "tamara@mowry.com");
        Payment check = new Check(81L, "Tia Mowry", "11432543", "134344551");

        payment[0] = paypal;
        payment[1] = check;

        PaymentPresenter presenter = new PaymentPresenter();
        String expected = "Paypal Tamara Mowry tamara@mowry.com\nCheck Tia Mowry ***2543\n";

        String actual = presenter.toStringByPayerName(payment);
        assertEquals(expected, actual);
    }

    //Create a test case to test the toStringById method of the PaymentPresenter class

    @Test
    public void toStringById(){
        Payment[] payment = new Payment[1];
        Payment paypal = new PayPal(120L, "Tamara Mowry", "tamara@mowry.com");

        payment[0] = paypal;
        PaymentPresenter presenter = new PaymentPresenter();

        String expected = "Paypal Tamara Mowry tamara@mowry.com";
        String actual = presenter.toStringById(payment);
        assertEquals(expected, actual);

    }

    //When there are multiple payments, you need to sort by creating a lambda to sort the payment by id,
    // then build the string using the short description
    @Test
    public void sortByID() {
        Payment[] payment = new Payment[2];
        Payment paypal = new PayPal(120L, "Tamara Mowry", "tamara@mowry.com");
        Payment check = new Check(81L, "Tia Mowry", "11432543", "134344551");

        payment[0] = paypal;
        payment[1] = check;

        PaymentPresenter presenter = new PaymentPresenter();
        String expected = "Check Tia Mowry ***2543\nPaypal Tamara Mowry tamara@mowry.com\n";

        String actual = presenter.toStringById(payment);
        assertEquals(expected, actual);
    }
}
