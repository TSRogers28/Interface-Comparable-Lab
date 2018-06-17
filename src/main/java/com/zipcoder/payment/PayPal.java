package com.zipcoder.payment;

public class PayPal implements Payment {

    private long id;
    private String payerName;
    private String email;

    public  PayPal(long id, String payerName, String email){
        this.id = id;
        this.payerName = payerName;
        this.email = email;
    }

    public  PayPal(String payerName, String email){
        this.payerName = payerName;
        this.email = email;
    }

    public PayPal(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(long id) {
        this.id = id;
    }


    public Long getId(){
        return id;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerName(){
        return payerName;
    }
    public String getShortDescription(){
      return  "Paypal " + getPayerName() + " " + getEmail();
    }

    public int compareTo(Payment payment){
        return this.getId().compareTo(payment.getId());
    }


}
