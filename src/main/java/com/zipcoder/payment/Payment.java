package com.zipcoder.payment;

public interface Payment extends Comparable<Payment>{

    public Long getId();
    public String getPayerName();
    public String getShortDescription();


}
