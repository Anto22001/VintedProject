package com.example.demo.repository;

import com.example.demo.model.AcquistoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcquistoRepository {
    @Autowired
    JdbcTemplate db_vinted;

    public boolean createAcquisto(AcquistoModel a){
        int rowAffected = db_vinted.update("insert into vinted.acquisto(id,id_acquirente,id_articolo,data_acquisto,modalita_spedizione, data_spedizione) " +
                        "values (?,?,?,?,?,?)",
                a.getId(),a.getId_acquirente(),a.getId_articolo(), a.getData_acquisto(), a.getMode_spedizione(),a.getData_spedizione());
        //chiama metodo cancella articoli da ogni wishlist
        return rowAffected>0;
    }

    public boolean removeAcquisto(String id){
        int rowAffected = db_vinted.update("delete from vinted.acquisto where id=?",id);
        return rowAffected>0;
    }

    public List<AcquistoModel> getAcquisti(){
        return this.db_vinted.query("select * from vinted.acquisto ORDER BY data_acquisto;",
                (rs, rowNum) ->
                        new AcquistoModel(
                                rs.getString("id"),
                                rs.getString("id_acquirente"),
                                rs.getString("id_articolo"),
                                rs.getString("modalita_spedizione"),
                                rs.getDate("data_spedizione").toLocalDate()
                        )
        );
    }

    public List<AcquistoModel> getAcquistiUtente(String id_utente){
        return this.db_vinted.query("select * from acquisto where id=? ORDER BY data_acquisto;",
                (rs, rowNum) ->
                        new AcquistoModel(
                                rs.getString("id"),
                                rs.getString("id_acquirente"),
                                rs.getString("id_articolo"),
                                rs.getString("modalita_spedizione"),
                                rs.getDate("data_spedizione").toLocalDate()
                        ),id_utente
        );
    }

    public List<AcquistoModel> getAcquistiRangeTempo(int range){
        return this.db_vinted.query("SELECT * FROM vinted.acquisto WHERE data_acquisto >=date_trunc('day', NOW() - ?::interval) AND data_acquisto <= now();",
                (rs, rowNum) ->
                        new AcquistoModel(
                                rs.getString("id"),
                                rs.getString("id_acquirente"),
                                rs.getString("id_articolo"),
                                rs.getString("modalita_spedizione"),
                                rs.getDate("data_spedizione").toLocalDate()
                        ),
                "'" + range + " months'"
        );
    }
}
