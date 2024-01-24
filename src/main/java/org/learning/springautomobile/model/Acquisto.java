package org.learning.springautomobile.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
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

    @NotNull(message = "La quantità non può essere 0")
    private int quantità;

    @ManyToOne
    private Auto auto;
    //Costruttori

    //Metodi
    public BigDecimal getPrezzo(){
        return this.auto.getPrice();
    }

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

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
}
