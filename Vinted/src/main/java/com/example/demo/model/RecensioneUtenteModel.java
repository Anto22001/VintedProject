package com.example.demo.model;

import java.time.LocalDate;
import java.util.Objects;

public class RecensioneUtenteModel {
    private String id, id_recensore, id_recensito, titolo, testo;
    private int valutazione;
    private LocalDate data_pubblicazione;

    public RecensioneUtenteModel(String id, String id_recensore, String id_recensito, String titolo, String testo, int valutazione, LocalDate data_pubblicazione) {
        this.id = id;
        this.id_recensore = id_recensore;
        this.id_recensito = id_recensito;
        this.titolo = titolo;
        this.testo = testo;
        this.valutazione = valutazione;
        this.data_pubblicazione = data_pubblicazione;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_recensore() {
        return id_recensore;
    }

    public void setId_recensore(String id_recensore) {
        this.id_recensore = id_recensore;
    }

    public String getId_recensito() {
        return id_recensito;
    }

    public void setId_recensito(String id_recensito) {
        this.id_recensito = id_recensito;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public LocalDate getData_pubblicazione() {
        return data_pubblicazione;
    }

    public void setData_pubblicazione(LocalDate data_pubblicazione) {
        this.data_pubblicazione = data_pubblicazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecensioneUtenteModel that = (RecensioneUtenteModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RecensioneUtente{" +
                "id='" + id + '\'' +
                ", id_recensore='" + id_recensore + '\'' +
                ", id_recensito='" + id_recensito + '\'' +
                ", titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                ", valutazione=" + valutazione +
                ", data_pubblicazione=" + data_pubblicazione +
                '}';
    }
}
