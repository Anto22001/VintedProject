package com.example.demo.repository;

import com.example.demo.model.ArticoloModel;
import com.example.demo.model.CategoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaArticoloRepository {
    @Autowired
    JdbcTemplate db_vinted;
    public boolean associateCategoriaArticolo(String id_categoria, String id_articolo){
        int rowAffected = db_vinted.update("insert into vinted.categoria_articolo(id_articolo,id_categoria) values (?,?)",
                id_articolo,id_categoria);
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

    public List<ArticoloModel> getArticoliCategoria(CategoriaModel c){
        return this.db_vinted.query("select * from vinted.articolo, vinted.categoria_articolo where articolo.id=categoria_articolo.id_articolo and id_categoria=?",
                (rs, rowNum) ->
                        new ArticoloModel(
                                rs.getString("id"),
                                rs.getString("nome"),
                                rs.getString("descrizione"),
                                rs.getString("id_venditore"),
                                rs.getString("condizioni"),
                                rs.getString("luogo"),
                                rs.getDouble("prezzo")
                        ),c.getId()
        );
    }
}
