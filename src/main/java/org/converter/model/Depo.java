package org.converter.model;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Objects;

@Sheet
public class Depo {
    @SheetColumn("date")
    private String date;
    @SheetColumn("amount")
    private double amount;
    @SheetColumn("id")
    private int id;
    @SheetColumn("time")
    private String time;
    @SheetColumn("type")
    private String type;
    @SheetColumn("Fee")
    private double fee;
    @SheetColumn("sender")
    private Sender sender;
    @SheetColumn("recipient")
    private Recipient recipient;
    @SheetColumn("currency")
    private Currency currency;

    public Depo() {
    }

    public static Depo of(String date, double amount, int id, String time, String type, double fee) {
        Depo depo = new Depo();
        depo.date = date;
        depo.amount = amount;
        depo.id = id;
        depo.time = time;
        depo.type = type;
        depo.fee = fee;
        return depo;
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
        Depo depo = (Depo) o;
        return id == depo.id;
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
