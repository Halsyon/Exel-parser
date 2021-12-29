package org.converter.model;

import java.util.Objects;

public class Deposit {

    private String date;

    private double amount;

    private int id;

    private String time;

    private String type;

    private double fee;

    private Sender sender;

    private Recipient recipient;

    private Currency currency;

    public Deposit() {
    }

    public static Deposit of(String date, double amount, int id, String time, String type, double fee) {
        Deposit deposit = new Deposit();
        deposit.date = date;
        deposit.amount = amount;
        deposit.id = id;
        deposit.time = time;
        deposit.type = type;
        deposit.fee = fee;
        return deposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Deposit deposit = (Deposit) o;
        return id == deposit.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Depo: id=%s, amount=%s, data=%s, time=%s, type=%s, fee=%s, Sender=%s, Recipient=%s, Currency=%s",
                id, amount, date, time, type, fee, sender, recipient, currency);
    }
}
