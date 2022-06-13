package com.example.demo;

import java.time.LocalDate;
import java.util.Objects;

public class ArticoloModel {
    private String id, nome, descrizione, id_venditore, condizioni, luogo, id_categoria;
    private double prezzo;
    private boolean in_vendita;
    private LocalDate data_pubblicazione;

    public ArticoloModel(String id, String nome, String descrizione, String id_venditore, String condizioni, String luogo, String id_categoria, double prezzo, LocalDate data_pubblicazione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.id_venditore = id_venditore;
        this.condizioni = condizioni;
        this.luogo = luogo;
        this.id_categoria = id_categoria;
        this.prezzo = prezzo;
        this.data_pubblicazione = data_pubblicazione;
    }

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getId_venditore() {
        return id_venditore;
    }

    public void setId_venditore(String id_venditore) {
        this.id_venditore = id_venditore;
    }

    public String getCondizioni() {
        return condizioni;
    }

    public void setCondizioni(String condizioni) {
        this.condizioni = condizioni;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isIn_vendita() {
        return in_vendita;
    }

    public void setIn_vendita(boolean in_vendita) {
        this.in_vendita = in_vendita;
    }

    public LocalDate getData_pubblicazione() {
        return data_pubblicazione;
    }

    public void setData_pubblicazione(LocalDate data_pubblicazione) {
        this.data_pubblicazione = data_pubblicazione;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticoloModel that = (ArticoloModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ArticoloModel{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", id_venditore='" + id_venditore + '\'' +
                ", condizioni='" + condizioni + '\'' +
                ", luogo='" + luogo + '\'' +
                ", id_categoria='" + id_categoria + '\'' +
                ", prezzo=" + prezzo +
                ", stato=" + (in_vendita==true ? "IN VENDITA" : "VENDUTO") +
                ", data_pubblicazione=" + data_pubblicazione +
                '}';
    }
}

