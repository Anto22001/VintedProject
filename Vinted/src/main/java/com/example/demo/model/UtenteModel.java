package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class UtenteModel {
    private String id, nome, cognome, citta;
    private LocalDate data_nascita;
    private double val_media;

    public UtenteModel(String id, String nome, String cognome, LocalDate data_nascita, String citta, double val) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.citta = citta;
        this.val_media=val>0 ? val : 0;
    }

    public double getVal_media() {
        return val_media;
    }

    public void setVal_media(double val_media) {
        this.val_media = val_media;
    }

    /*public UtenteModel(String nome, String cognome, LocalDate data_nascita, String citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.citta = citta;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtenteModel that = (UtenteModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UtenteModel{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", citta='" + citta + '\'' +
                ", data_nascita=" + data_nascita +
                '}';
    }
}
