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
        int rowAffected = db_vinted.update("update vinted.articolo set nome=?,descrizione=?,id_venditore=?,condizioni=?,data=?,luogo=?,prezzo=? where id=?",
                a.getNome(),a.getDescrizione(),a.getId_venditore(),a.getCondizioni(),a.getData_pubblicazione(),a.getLuogo(),a.getPrezzo(),a.getId());
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
                                rs.getString("luogo"),
                                rs.getDouble("prezzo")
                        ));
    }

    public List<ArticoloModel> getArticoliUtente(String id_utente){
        return this.db_vinted.query("select * from articolo where id_venditore=? and in_vendita=true ORDER BY data_pubblicazione",
                (rs, rowNum) ->
                        new ArticoloModel(
                                rs.getString("id"),
                                rs.getString("nome"),
                                rs.getString("descrizione"),
                                rs.getString("id_venditore"),
                                rs.getString("condizioni"),
                                rs.getString("luogo"),
                                rs.getDouble("prezzo")
                        ),id_utente
        );
    }
}
