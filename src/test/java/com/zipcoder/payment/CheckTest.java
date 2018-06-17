package com.zipcoder.payment;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {

    Check check = new Check();

    @Test
    public void getRoutingNumber() {
        check.setRoutingNumber("928350383");

        String expected = "928350383";
        String actual = check.getRoutingNumber();

        assertEquals(actual, expected);
    }

    @Test
    public void getAccountNumber() {
        check.setAccountNumber("292472491014");

        String expected = "292472491014";
        String actual = check.getAccountNumber();

        assertEquals(actual, expected);
    }

    @Test
    public void getId() {
        check.setId(19838193);

        long expected =19838193;
        long actual = check.getId();

        assertEquals(actual, expected);
    }

    @Test
    public void getPayerName() {
        check.setPayerName("Xerces The Great");

        String expected = "Xerces The Great";
        String actual = check.getPayerName();

        assertEquals(actual, expected);
    }

    @Test
    public void getShortDescription() {
        check.setAccountNumber("1234 1723 1826 9736");
        check.setPayerName("Xerces The Great");


        String expected = "Check Xerces The Great ***9736";
        String actual = check.getShortDescription();

        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void compareTo(){
        Check check = new Check("Jimmy Dean", "297393022");
        PayPal pp = new PayPal("Slim Shady", "TheRealSlimShady@pleasestandup.com");

        assertTrue(check.compareTo(pp) < 0 );
    }
}