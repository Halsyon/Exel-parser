package org.converter.model;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

import java.util.Objects;
@Sheet
public class Sender {
    @SheetColumn("Sender_name")
    private String name;
    @SheetColumn("Sender_id")
    private int id;


    public Sender() {
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sender sender = (Sender) o;
        return id == sender.id
                && Objects.equals(name, sender.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return String.format("Sender: id=%s, name=%s",
                id, name);
    }
}
