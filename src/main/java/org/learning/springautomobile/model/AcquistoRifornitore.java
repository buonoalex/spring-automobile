package org.learning.springautomobile.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@Table(name = "acquisto_rifornitore")
public class AcquistoRifornitore {

    //Attributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(nullable = false)
    private LocalDate data;

    @NotNull
    @Column(nullable = false)
    private int quantita;

    @NotEmpty
    @Column(nullable = false)
    private String nomeFornitore;

    @NotNull
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private Auto auto;

    //Costruttore

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

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getNomeFornitore() {
        return nomeFornitore;
    }

    public void setNomeFornitore(String nomeFornitore) {
        this.nomeFornitore = nomeFornitore;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public String getFormattedPrice() {
        BigDecimal numero = new BigDecimal(String.valueOf(price));

        // Creazione di un oggetto DecimalFormat
        DecimalFormat formato = new DecimalFormat("#,###.00");

        // Formattazione del BigDecimal
        String numeroFormattato = formato.format(numero);

        return numeroFormattato;
    }
}
