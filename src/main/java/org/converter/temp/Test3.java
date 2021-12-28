package org.converter.temp;

import org.converter.model.Currency;
import org.converter.model.Depo;
import org.converter.model.Recipient;
import org.converter.model.Sender;

import java.sql.Timestamp;

public class Test3 {
    public static void main(String[] args) {
        Sender sender = new Sender();
        sender.setName("Albert");
        sender.setFee(14.47);
        sender.setId(60);
        Recipient recipient = new Recipient();
        recipient.setName("Vasiliy");
        recipient.setId(25);
        Currency currency = new Currency();
        currency.setId(1);
        currency.setLabel("USD");
        Depo depo = Depo.of("2016-12-22", 88.25, 1, "11:09:34", "DEPOSIT");
        depo.setSender(sender);
        depo.setRecipient(recipient);
        depo.setCurrency(currency);
        System.out.println(depo);
    }


}
