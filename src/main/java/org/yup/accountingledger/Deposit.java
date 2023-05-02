package org.yup.accountingledger;

public class Deposit {

    public String date;
    public double amount;
    public String description;

    public Deposit(String date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}