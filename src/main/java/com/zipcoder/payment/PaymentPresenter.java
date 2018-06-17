package com.zipcoder.payment;

import java.util.Arrays;
import java.util.Comparator;

public class PaymentPresenter {


    public String toString(Payment[] payment) {
        return buildString(sortMultiplePayments(payment));
    }

    public Payment[] sortMultiplePayments(Payment[] payment) {
        Arrays.sort(payment, Comparator.comparing(Payment::getShortDescription));
        return payment;
    }


    public String toStringByPayerName(Payment[] payment) {
        return buildString(sortByPayer(payment));
    }

    public Payment[] sortByPayer(Payment[] payment) {
        Arrays.sort(payment, Comparator.comparing(Payment::getPayerName));
        return payment;
    }

    public String toStringById(Payment[] payment) {
        return buildString(sortByID(payment));
    }

    public Payment [] sortByID(Payment[] payment){
        Arrays.sort(payment, Comparator.comparing(Payment::getId));
        return payment;
    }

    public String buildString(Payment[] payment){
        StringBuilder builder = new StringBuilder();
        for(Payment p : payment)
            builder.append(p.getShortDescription() + "\n");
        return builder.toString();
    }



}
