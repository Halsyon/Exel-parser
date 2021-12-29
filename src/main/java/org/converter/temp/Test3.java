package org.converter.temp;

import org.converter.model.Currency;
import org.converter.model.Deposit;
import org.converter.model.Recipient;
import org.converter.model.Sender;

public class Test3 {
    public static void main(String[] args) {
        Sender sender = new Sender();
        sender.setName("Albert");
        sender.setId(60);
        Recipient recipient = new Recipient();
        recipient.setName("Vasiliy");
        recipient.setId(25);
        Currency currency = new Currency();
        currency.setId(1);
        currency.setLabel("USD");
        Deposit deposit = Deposit.of("2016-12-22", 88.25, 1, "11:09:34", "DEPOSIT", 14.47);
        deposit.setSender(sender);
        deposit.setRecipient(recipient);
        deposit.setCurrency(currency);
        System.out.println(deposit);
    }


}
