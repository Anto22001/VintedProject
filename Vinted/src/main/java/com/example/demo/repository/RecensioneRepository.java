package com.example.demo.repository;

import com.example.demo.model.RecensioneUtenteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecensioneRepository {
    @Autowired
    JdbcTemplate db_vinted;
    public boolean createRecensione(RecensioneUtenteModel r){
        int rowAffected = db_vinted.update("insert into vinted.recensione(id,id_recensore,id_recensito,titolo,testo,valutazione,data_pubblicazione) " +
                        "values (?,?,?,?,?,?,?)",
                r.getId(),r.getId_recensore(),r.getId_recensito(),r.getTitolo(),r.getTesto(),r.getValutazione(),r.getData_pubblicazione());
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
}
