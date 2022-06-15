package com.example.demo.repository;

import com.example.demo.model.RecensioneUtenteModel;
import com.example.demo.model.UtenteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecensioneRepository {
    @Autowired
    JdbcTemplate db_vinted;
    public boolean createRecensione(RecensioneUtenteModel r){
        int rowAffected = db_vinted.update("insert into vinted.recensione(id,id_recensito,id_recensore,titolo,testo,valutazione,data_pubblicazione) " +
                        "values (?,?,?,?,?,?,?)",
                r.getId(),r.getId_recensito(),r.getId_recensore(),r.getTitolo(),r.getTesto(),r.getValutazione(),r.getData_pubblicazione());
        return rowAffected>0;
    }

    public boolean removeRecensione(String id){
        int rowAffected = db_vinted.update("delete from vinted.recensione where id=?",id);
        return rowAffected>0;
    }

    public boolean updateRecensione(RecensioneUtenteModel r){
        int rowAffected = db_vinted.update("update vinted.recensione set titolo=?,testo=?,valutazione=? where id=?",
                r.getTitolo(),r.getTesto(),r.getValutazione(),r.getId());
        return rowAffected>0;
    }

    public List<RecensioneUtenteModel> getRecensioni(){
        return this.db_vinted.query("select * from vinted.recensione ORDER BY valutazione,data_pubblicazione;",
                (rs, rowNum) ->
                        new RecensioneUtenteModel(
                                rs.getString("id"),
                                rs.getString("id_recensore"),
                                rs.getString("id_recensito"),
                                rs.getString("titolo"),
                                rs.getString("testo"),
                                rs.getInt("valutazione"),
                                rs.getDate("data_pubblicazione").toLocalDate()
                        )
        );
    }

    public List<Double> valutazioneMedia(UtenteModel u){
        double ris;
        List<Double> var = this.db_vinted.query("select avg(valutazione) as val from vinted.recensione where id_recensito=?;",
                (rs,rowNum)->rs.getDouble("val"),u.getId());
        u.setVal_media(var.get(0));
        ris=var.get(0);
        this.db_vinted.update("update vinted.utente set valutazione_media=? where id=?",ris,u.getId());
        return var;
    }
}
