package com.zipcoder.payment;

public class Check implements Payment{

    private long id;
    private String payerName;
    private String routingNumber;
    private String accountNumber;

    public Check(long id, String payerName, String accountNumber, String routingNumber){
        this.id = id;
        this.payerName = payerName;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public Check(String payerName, String accountNumber){
        this.payerName = payerName;
        this.accountNumber = accountNumber;
    }

    public Check(){

    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
        return "Check " + getPayerName() + " ***" +
                getAccountNumber().substring(getAccountNumber().length()-4, getAccountNumber().length());
    }

    public int compareTo(Payment o) {
        return this.getId().compareTo(o.getId());

    }

}
