package org.converter.model;

import lombok.*;

import java.util.Objects;

@Data
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

       public static Deposit of(String date, double amount,
                                int id, String time,
                                String type, double fee) {
        Deposit deposit = new Deposit();
        deposit.date = date;
        deposit.amount = amount;
        deposit.id = id;
        deposit.time = time;
        deposit.type = type;
        deposit.fee = fee;
        return deposit;
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

//    @Override
//    public String toString() {
//        return String.format("Deposit: id=%s, amount=%s, data=%s, time=%s, type=%s, fee=%s, Sender=%s, Recipient=%s, Currency=%s",
//                id, amount, date, time, type, fee, sender, recipient, currency);
//    }
}
