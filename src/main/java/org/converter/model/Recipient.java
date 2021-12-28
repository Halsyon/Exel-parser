package org.converter.model;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

import java.util.Objects;
@Sheet
public class Recipient {
    @SheetColumn("Recipient_name")
    private String name;
    @SheetColumn("Recipient_id")
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
