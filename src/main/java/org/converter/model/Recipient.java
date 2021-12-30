package org.converter.model;

import lombok.*;

import java.util.Objects;

@Data
public class Recipient {

    private String name;

    private int id;

//    @Override
//    public String toString() {
//        return String.format("Recipient: id=%s, name=%s",
//                id, name);
//    }
}
