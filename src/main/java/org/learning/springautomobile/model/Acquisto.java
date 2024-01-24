package org.learning.springautomobile.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Acquisto {

    //Attributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Questo campo non può essere vuoto")
    private LocalDate data;

    @ManyToOne
    private Set<Auto> autoSet;

    //Costruttori

    //Metodi

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Set<Auto> getAutoSet() {
        return autoSet;
    }

    public void setAutoSet(Set<Auto> autoSet) {
        this.autoSet = autoSet;
    }
}
