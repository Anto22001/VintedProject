package com.example.demo.repository;

import com.example.demo.model.CategoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository {
    @Autowired
    JdbcTemplate db_vinted;
    public boolean createCategory(CategoriaModel c){
        int rowAffected = db_vinted.update("insert into vinted.categoria(id,nome) values (?,?)",
                c.getId(),c.getNome());
        return rowAffected>0;
    }

    public boolean removeCategory(String id){
        int rowAffected = db_vinted.update("delete from vinted.categoria where id=?",id);
        return rowAffected>0;
    }

    public boolean updateCategory(CategoriaModel c){
        int rowAffected = db_vinted.update("update vinted.categoria set nome=? where id=?",c.getNome(),c.getId());
        return rowAffected>0;
    }

    public List<CategoriaModel> getCategorie(){
        return this.db_vinted.query("select * from vinted.categoria ORDER BY id;",
                (rs, rowNum) ->
                        new CategoriaModel(
                                rs.getString("id"),
                                rs.getString("nome")
                        )
        );
    }
}
