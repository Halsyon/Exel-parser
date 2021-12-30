package org.converter.model;

import lombok.*;

@Data
public class Currency {

    private int id;

    private String label;

//    @Override
//    public String toString() {
//        return String.format("Currency: id=%s, label=%s",
//                id, label);
//    }
}
