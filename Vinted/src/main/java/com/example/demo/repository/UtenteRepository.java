package com.example.demo.repository;

import com.example.demo.model.UtenteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtenteRepository {
    @Autowired
    JdbcTemplate db_vinted;

    //utente
    public boolean createUser(UtenteModel u){
        int rowAffected = db_vinted.update("insert into vinted.utente(id,nome,cognome,data_nascita,citta) values (?,?,?,?,?)",
                        u.getId(),u.getNome(),u.getCognome(),u.getData_nascita(),u.getCitta());
        return rowAffected>0;
    }

    public boolean removeUser(String id){
        int rowAffected = db_vinted.update("delete from vinted.utente where id=?",id);
        return rowAffected>0;
    }

    public boolean updateUser(UtenteModel u){
        int rowAffected = db_vinted.update("update vinted.utente set nome=?, cognome=?, data_nascita=?, citta=? where id=?",u.getNome(),u.getCognome(),u.getData_nascita(),u.getCitta(),u.getId());
        return rowAffected>0;
    }

    public List<UtenteModel> getUtenti(){
        return this.db_vinted.query("select * from vinted.utente ORDER BY id;",
            (rs, rowNum) ->
                new UtenteModel(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getDate("data_nascita").toLocalDate(),
                        rs.getString("citta"),
                        rs.getDouble("valutazione_media")
                )
        );
    }

    public List<UtenteModel> getUtente(String id_utente){
        return this.db_vinted.query("select * from vinted.utente where id=?;",
                (rs, rowNum) ->
                        new UtenteModel(
                                rs.getString("id"),
                                rs.getString("nome"),
                                rs.getString("cognome"),
                                rs.getDate("data_nascita").toLocalDate(),
                                rs.getString("citta"),
                                rs.getDouble("valutazione_media")
                        ),id_utente
        );
    }


    public boolean createCategoriaArticolo(String id_articolo, String id_categoria){
        int rowAffected = db_vinted.update("insert into vinted.categoria_articolo(id_articolo, id_categoria) values (?,?))",
                id_articolo, id_categoria);
        return rowAffected>0;
    }



}
