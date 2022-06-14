package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaPreferitaRepository {
    @Autowired
    JdbcTemplate db_vinted;

    public boolean associateCategoriaUtente(String id_categoria, String id_utente){
        int rowAffected = db_vinted.update("insert into vinted.categoria_preferita(id_categoria,id_utente) values (?,?)",
                id_categoria,id_utente);
        return rowAffected>0;
    }

    public boolean removeCategoriaUtente(String id_categoria,String id_utente){
        int rowAffected = db_vinted.update("delete from vinted.categoria_preferita where id_categoria=? and id_utente=?",
                id_categoria,id_utente);
        return rowAffected>0;
    }

    public boolean updateCategoriaUtente(String new_idc, String new_idu, String id_categoria, String id_utente){
        int rowAffected = db_vinted.update("update vinted.categoria_preferita set id_categoria=?, id_utente=? where id_categoria=? and id_utente=?",
                new_idc,new_idu,id_categoria,id_utente);
        return rowAffected>0;
    }
}
