package org.learning.springautomobile.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashSet;
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

    @NotEmpty
    private String logo;

    @NotEmpty
    private String marca;

    @NotEmpty
    private String cambio;

    @Min(0)
    private int anno;

    @NotEmpty(message = "seleziona un tipo di carburante")
    private String carburante;

    @NotNull
    @Min(0)
    private int kmL;

    @NotNull
    @Min(0)
    private int cavalli;

    @ManyToOne
    private AutoType autoType;

    @OneToMany(mappedBy = "auto",orphanRemoval = true)
    private Set<AcquistoCliente> acquistoClienteSet = new HashSet<>();

    @OneToMany(mappedBy = "auto", orphanRemoval = true)
    private Set<AcquistoRifornitore> acquistoRifornitoreSet = new HashSet<>();

    // method
    //methodo per contare quante auto sono state acquistate
  /*  public int autoMagazzino() {
        int countVendite = 0;
        int countAcquisti = 0;
        for (AcquistoCliente vendite : acquistoClienteSet){
            countVendite = vendite.getQuantita() + countVendite;
        }
        for (AcquistoRifornitore acquisti : acquistoRifornitoreSet) {
            countAcquisti = acquisti.getQuantita() + countAcquisti;
        }
        int mammt = countAcquisti - countVendite;
        return mammt;
    } */

    public int vendite() {
        int countVendite = 0;
        for (AcquistoCliente vendite : acquistoClienteSet) {
            countVendite = vendite.getQuantita() + countVendite;
        }
        return countVendite;
    }

    public int acquisti() {
        int countAcquisti = 0;
        for (AcquistoRifornitore acquisti : acquistoRifornitoreSet) {
            countAcquisti = acquisti.getQuantita() + countAcquisti;
        }
        return countAcquisti;
    }

    public int magazzino() {
        return acquisti() - vendite();
    }

    public String totalePrezzoUtente(int quantita) {
        BigDecimal prezzoFinale = new BigDecimal(quantita).multiply(price);
        BigDecimal numero = new BigDecimal(String.valueOf(prezzoFinale));

        // Creazione di un oggetto DecimalFormat
        DecimalFormat formato = new DecimalFormat("#,###.00");

        // Formattazione del BigDecimal
        String numeroFormattato = formato.format(numero);
        return numeroFormattato;
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

    public String getFormattedPrice() {
        BigDecimal numero = new BigDecimal(String.valueOf(price));

        // Creazione di un oggetto DecimalFormat
        DecimalFormat formato = new DecimalFormat("#,###.00");

        // Formattazione del BigDecimal
        String numeroFormattato = formato.format(numero);

        return numeroFormattato;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getCarburante() {
        return carburante;
    }

    public void setCarburante(String carburante) {
        this.carburante = carburante;
    }

    public int getKmL() {
        return kmL;
    }

    public void setKmL(int kmL) {
        this.kmL = kmL;
    }

    public int getCavalli() {
        return cavalli;
    }

    public void setCavalli(int cavalli) {
        this.cavalli = cavalli;
    }

    //Override
    @Override
    public boolean equals(Object obj) {
        // Verifica se gli oggetti sono della stessa istanza
        if (this == obj) {
            return true;
        }

        // Verifica se l'oggetto passato è nullo o di una classe diversa
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Effettua il casting dell'oggetto al tipo della tua classe
        Auto altro = (Auto) obj;

        // Confronta le marche
        return marca != null ? marca.equals(altro.marca) : altro.marca == null;
    }

    // Il metodo hashCode dovrebbe essere sovrascritto quando si sovrascrive equals
    @Override
    public int hashCode() {
        return marca != null ? marca.hashCode() : 0;
    }

}
