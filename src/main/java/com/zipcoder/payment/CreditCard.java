package com.zipcoder.payment;

public class CreditCard implements Payment {

    private long id;
    private String payerName;
    String number;
    int expiredMonth;
    int expiredYear;

    public CreditCard(long id, String payerName, String number, int expiredMonth, int expiredYear){
        this.id = id;
        this.payerName = payerName;
        this.number =number;
        this.expiredMonth = expiredMonth;
        this.expiredYear =expiredYear;
    }

    public CreditCard(String payerName, String number, int expiredMonth, int expiredYear){
        this.payerName = payerName;
        this.number =number;
        this.expiredMonth = expiredMonth;
        this.expiredYear =expiredYear;
    }

    public  CreditCard(){

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getExpiredMonth() {
        return expiredMonth;
    }

    public void setExpiredMonth(int expiredMonth) {
        this.expiredMonth = expiredMonth;
    }

    public int getExpiredYear() {
        return expiredYear;
    }

    public void setExpiredYear(int expiredYear) {
        this.expiredYear = expiredYear;
    }

    public void setId(long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setPayerName(String payerName){
       this.payerName = payerName;
    }
    public String getPayerName(){
        return payerName;
    }

    public String getShortDescription(){
        return "CC " + getPayerName() + " " +
                getNumber().substring(getNumber().length()-4, getNumber().length()) + " " +
                getExpiredMonth() + "/" + getExpiredYear();
    }
    public int compareTo(Payment payment){
       return this.getId().compareTo(payment.getId());
    }

}
