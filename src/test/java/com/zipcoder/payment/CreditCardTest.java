package com.zipcoder.payment;

import static org.junit.Assert.*;

public class CreditCardTest {

    CreditCard card = new CreditCard();

    @org.junit.Test
    public void getId() {
        card.setId(19838193);

        long expected =19838193;
        long actual = card.getId();

        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void getPayerName() {
        card.setPayerName("Xerces The Great");

        String expected = "Xerces The Great";
        String actual = card.getPayerName();

        assertEquals(actual, expected);

    }

    @org.junit.Test
    public void getNumber() {
        card.setNumber("1234 1723 1826 9736");

        String expected = "1234 1723 1826 9736";
        String actual = card.getNumber();

        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void getExpiredMonth() {
        card.setExpiredMonth(11);

        int expected = 11;
        int actual = card.getExpiredMonth();

        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void getExpiredYear() {
        card.setExpiredYear(535);

        int expected = 535;
        int actual = card.getExpiredYear();

        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void getShortDescription() {
        card.setExpiredYear(535);
        card.setExpiredMonth(11);
        card.setNumber("1234 1723 1826 9736");
        card.setPayerName("Xerces The Great");


        String expected = "CC Xerces The Great 9736 11/535";
        String actual = card.getShortDescription();

        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void compareTo(){
        CreditCard cc = new CreditCard(889L,"Jimmy Dean", "1023 2983 0839 2938", 9, 2040);
        PayPal pp = new PayPal(993L,"Slim Shady", "TheRealSlimShady@pleasestandup.com");

        assertTrue(cc.compareTo(pp) < 0 );
    }


}