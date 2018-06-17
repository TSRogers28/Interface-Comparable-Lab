package com.zipcoder.payment;

import org.junit.Test;

import static org.junit.Assert.*;

public class PayPalTest {

    PayPal payPal = new PayPal();

    @Test
    public void getEmail() {
        payPal.setEmail("IConquerBecauseIamLonely@ruleworld.com");

        String expected = "IConquerBecauseIamLonely@ruleworld.com";
        String actual = payPal.getEmail();

        assertEquals(actual, expected);
    }

    @Test
    public void getId() {
        payPal.setId(19838193);

        long expected =19838193;
        long actual = payPal.getId();

        assertEquals(actual, expected);
    }

    @Test
    public void getPayerName() {
        payPal.setPayerName("Xerces The Great");

        String expected = "Xerces The Great";
        String actual = payPal.getPayerName();

        assertEquals(actual, expected);
    }

    @Test
    public void getShortDescription() {
        payPal.setEmail("IConquerBecauseIamLonely@ruleworld.com");
        payPal.setPayerName("Xerces The Great");


        String expected = "Paypal Xerces The Great IConquerBecauseIamLonely@ruleworld.com";
        String actual = payPal.getShortDescription();

        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void compareTo(){
        CreditCard cc = new CreditCard("Jimmy Dean", "1023 2983 0839 2938", 9, 2040);
        PayPal pp = new PayPal("Slim Shady", "TheRealSlimShady@pleasestandup.com");

        assertTrue(cc.compareTo(pp) < 0 );
    }
}