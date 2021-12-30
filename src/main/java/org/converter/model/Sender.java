package org.converter.model;

import lombok.*;

import java.util.Objects;

@Data
public class Sender {

    private String name;

    private int id;

//    @Override
//    public String toString() {
//        return String.format("Sender: id=%s, name=%s",
//                id, name);
//    }
}
