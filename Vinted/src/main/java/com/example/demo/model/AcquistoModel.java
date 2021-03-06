package com.example.demo.model;

import java.time.LocalDate;
import java.util.Objects;

public class AcquistoModel {
    private int id;
    private String id_acquirente, id_articolo;
    private String mode_spedizione;
    private LocalDate data_acquisto, data_spedizione;

    public AcquistoModel(){
        this.data_acquisto=LocalDate.now();
    }
    public AcquistoModel(String id_acquirente, String id_articolo, String mode_spedizione, LocalDate data_acquisto, LocalDate data_spedizione) {
        this.id_acquirente = id_acquirente;
        this.id_articolo = id_articolo;
        this.mode_spedizione = mode_spedizione;
        this.data_acquisto = data_acquisto;
        this.data_spedizione = data_spedizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_acquirente() {
        return id_acquirente;
    }

    public void setId_acquirente(String id_acquirente) {
        this.id_acquirente = id_acquirente;
    }

    public String getId_articolo() {
        return id_articolo;
    }

    public void setId_articolo(String id_articolo) {
        this.id_articolo = id_articolo;
    }

    public String getMode_spedizione() {
        return mode_spedizione;
    }

    public void setMode_spedizione(String mode_spedizione) {
        this.mode_spedizione = mode_spedizione;
    }

    public LocalDate getData_acquisto() {
        return data_acquisto;
    }

    public void setData_acquisto(LocalDate data_acquisto) {
        this.data_acquisto = data_acquisto;
    }

    public LocalDate getData_spedizione() {
        return data_spedizione;
    }

    public void setData_spedizione(LocalDate data_spedizione) {
        this.data_spedizione = data_spedizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcquistoModel that = (AcquistoModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AcquistoModel{" +
                "id='" + id + '\'' +
                ", id_acquirente='" + id_acquirente + '\'' +
                ", id_articolo='" + id_articolo + '\'' +
                ", mode_spedizione=" + mode_spedizione +
                ", data_acquisto=" + data_acquisto +
                ", data_spedizione=" + data_spedizione +
                '}';
    }
}


