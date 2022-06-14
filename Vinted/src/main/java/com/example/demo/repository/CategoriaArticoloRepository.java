package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaArticoloRepository {
    @Autowired
    JdbcTemplate db_vinted;
    public boolean associateCategoriaArticolo(String id_categoria, String id_articolo){
        int rowAffected = db_vinted.update("insert into vinted.categoria_articolo(id_categoria,id_articolo) values (?,?)",
                id_categoria,id_articolo);
        return rowAffected>0;
    }

    public boolean removeCategoriaArticolo(String id_categoria,String id_articolo){
        int rowAffected = db_vinted.update("delete from vinted.categoria_articolo where id_categoria=? and id_articolo=?",
                id_categoria,id_articolo);
        return rowAffected>0;
    }

    public boolean updateCategoriaArticolo(String new_idc, String new_ida, String id_categoria, String id_articolo){
        int rowAffected = db_vinted.update("update vinted.categoria_articolo set id_categoria=?, id_articolo=? where id_categoria=? and id_articolo=?",
                new_idc,new_ida,id_categoria,id_articolo);
        return rowAffected>0;
    }
}
