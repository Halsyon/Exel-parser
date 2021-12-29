package org.converter.model;

import java.util.Objects;

public class Recipient {

    private String name;

    private int id;

    public Recipient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipient recipient = (Recipient) o;
        return id == recipient.id
                && Objects.equals(name, recipient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return String.format("Recipient: id=%s, name=%s",
                id, name);
    }
}
