package com.example.demo.repository;

import com.example.demo.model.ArticoloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticoloWishListRepository {
    @Autowired
    JdbcTemplate db_vinted;

    public boolean associateArticoloWishlist(String id_articolo, String id_wishlist){
        int rowAffected = db_vinted.update("insert into vinted.articolo_wishlist(id_articolo,id_wishlist) values (?,?)",
                id_articolo,id_wishlist);
        return rowAffected>0;
    }

    public boolean removeArticoloWishlist(String id_articolo, String id_wishlist){
        int rowAffected = db_vinted.update("delete from vinted.articolo_wishlist where id_articolo=? and id_wishlist=?",
                id_articolo,id_wishlist);
        return rowAffected>0;
    }

    public boolean updateArticoloWishlist(String new_ida, String new_idw, String id_articolo, String id_wishlist){
        int rowAffected = db_vinted.update("update vinted.articolo_wishlist set id_articolo=?, id_wishlist=? where id_articolo=? and id_wishlist=?",
                new_ida,new_idw,id_articolo,id_wishlist);
        return rowAffected>0;
    }

    public void removeArticoloFromEveryWishlists(ArticoloModel a){
       db_vinted.update("delete from vinted.articolo_wishlist where id_articolo=?", a.getId());
    }

    public List<String> getArticoliWishlist(String idWishlist) {
        return db_vinted.query("select id_articolo from vinted.articolo_wishlist where id_wishlist =?",
                (rs, rowNum) ->
                        rs.getString("id_articolo")
                ,idWishlist
        );
    }
}