/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author KORISNIK
 */
@Entity
public class Proizvod {
    @Id
    private long idProizvod;
    private String naziv;
    private BigDecimal cena;

    public Proizvod() {
    }

    public Proizvod(long idProizvod, String naziv, BigDecimal cena) {
        this.idProizvod = idProizvod;
        this.naziv = naziv;
        this.cena = cena;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(long idProizvod) {
        this.idProizvod = idProizvod;
    }

    @Override
    public String toString() {
        return "Proizvod{" + "idProizvod=" + idProizvod + ", naziv=" + naziv + ", cena=" + cena + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (this.idProizvod ^ (this.idProizvod >>> 32));
        hash = 11 * hash + Objects.hashCode(this.naziv);
        hash = 11 * hash + Objects.hashCode(this.cena);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proizvod other = (Proizvod) obj;
        if (this.idProizvod != other.idProizvod) {
            return false;
        }
        return true;
    }
    
    
}
