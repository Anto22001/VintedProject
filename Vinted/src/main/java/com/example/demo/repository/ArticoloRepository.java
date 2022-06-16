package com.example.demo.repository;

import com.example.demo.model.ArticoloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticoloRepository {
    @Autowired
    JdbcTemplate db_vinted;

    public boolean createArticolo(ArticoloModel a){
        int rowAffected = db_vinted.update("insert into vinted.articolo(id,nome,descrizione,id_venditore,condizioni,data_pubblicazione,luogo,prezzo) " +
                        "values (?,?,?,?,?,?,?,?)",
                a.getId(),a.getNome(),a.getDescrizione(),a.getId_venditore(),a.getCondizioni(),a.getData_pubblicazione(),a.getLuogo(),a.getPrezzo());
        return rowAffected>0;
    }

    public boolean removeArticolo(String id){
        int rowAffected = db_vinted.update("update vinted.articolo set in_vendita=false where id=?",id);
        return rowAffected>0;
    }

    public boolean updateArticolo(ArticoloModel a){
        int rowAffected = db_vinted.update("update vinted.articolo set nome=?,descrizione=?,id_venditore=?,condizioni=?,data_pubblicazione=?,luogo=?,prezzo=?,in_vendita=? where id=?",
                a.getNome(),a.getDescrizione(),a.getId_venditore(),a.getCondizioni(),a.getData_pubblicazione(),a.getLuogo(),a.getPrezzo(),a.isIn_vendita(),a.getId());
        return rowAffected>0;
    }

    public List<ArticoloModel> getArticoli(){
        return this.db_vinted.query("select * from vinted.articolo ORDER BY data_pubblicazione;",
                (rs, rowNum) ->
                        new ArticoloModel(
                                rs.getString("id"),
                                rs.getString("nome"),
                                rs.getString("descrizione"),
                                rs.getString("id_venditore"),
                                rs.getString("condizioni"),
                                rs.getDate("data_pubblicazione").toLocalDate(),
                                rs.getString("luogo"),
                                rs.getDouble("prezzo"),
                                rs.getBoolean("in_vendita")
                        ));
    }

    public List<ArticoloModel> getArticoliUtente(String id_utente){
        return this.db_vinted.query("select * from vinted.articolo where id_venditore=? and in_vendita=true ORDER BY data_pubblicazione",
                (rs, rowNum) ->
                        new ArticoloModel(
                                rs.getString("id"),
                                rs.getString("nome"),
                                rs.getString("descrizione"),
                                rs.getString("id_venditore"),
                                rs.getString("condizioni"),
                                rs.getDate("data_pubblicazione").toLocalDate(),
                                rs.getString("luogo"),
                                rs.getDouble("prezzo"),
                                rs.getBoolean("in_vendita")
                        ),id_utente
        );
    }

    public double getGuadagno(String u){
        List<Double> var = this.db_vinted.query("select sum(prezzo) as p from vinted.acquisto, vinted.articolo where acquisto.id_articolo=articolo.id and id_venditore=?",
                (rs, rowNum) ->rs.getDouble("p"),u);
        return var.get(0);
    }

    public List<ArticoloModel> articoliVenduti(String id_venditore){
        return this.db_vinted.query("select * from vinted.articolo where id_venditore=? and in_vendita=false",
                (rs,rowNum)->new ArticoloModel(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("descrizione"),
                        rs.getString("id_venditore"),
                        rs.getString("condizioni"),
                        rs.getDate("data_pubblicazione").toLocalDate(),
                        rs.getString("luogo"),
                        rs.getDouble("prezzo"),
                        rs.getBoolean("in_vendita")
                ),id_venditore
        );
    }


}
