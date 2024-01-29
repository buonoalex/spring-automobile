package org.learning.springautomobile.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "automobili")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Lob
    private String description;

    private String foto;

    @NotNull
    @Min(1)
    private BigDecimal price;

    /*
    @NotNull
    @Min(1) // da vedere se partire da un minimo di 0 o di 1 per dire se nel concessionario ci può non essere più un'auto o ce nè deve essere almeno 1
    private Integer quantityAuto;

     */

    @ManyToOne
    private AutoType autoType;

    @OneToMany(mappedBy = "auto",orphanRemoval = true)
    private Set<AcquistoCliente> acquistoClienteSet= new HashSet<>();

    @OneToMany(mappedBy = "auto",orphanRemoval = true)
    private Set<AcquistoRifornitore> acquistoRifornitoreSet = new HashSet<>();

    // method
    //methodo per contare quante auto sono state acquistate
    public int autoAquistate () {
        int countAcquisti = 0;
        for (int i = 0; i <acquistoClienteSet.size() ; i++) {
            if (acquistoClienteSet.contains(this.id)) {
                countAcquisti ++;
            }

        }
        return countAcquisti;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AutoType getAutoType() {
        return autoType;
    }

    public void setAutoType(AutoType autoType) {
        this.autoType = autoType;
    }

    public Set<AcquistoCliente> getAcquistoClienteSet() {
        return acquistoClienteSet;
    }

    public void setAcquistoClienteSet(Set<AcquistoCliente> acquistoClienteSet) {
        this.acquistoClienteSet = acquistoClienteSet;
    }

    public Set<AcquistoRifornitore> getAcquistoRifornitoreSet() {
        return acquistoRifornitoreSet;
    }

    public void setAcquistoRifornitoreSet(Set<AcquistoRifornitore> acquistoRifornitoreSet) {
        this.acquistoRifornitoreSet = acquistoRifornitoreSet;
    }
}
