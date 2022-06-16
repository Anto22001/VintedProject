package com.example.demo.repository;

import com.example.demo.model.WishListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepository {

    @Autowired
    JdbcTemplate db_vinted;
    public boolean createWishlist(WishListModel w){
        int rowAffected = db_vinted.update("insert into vinted.wishlist(id,id_utente,nome) " +
                        "values (?,?,?)",
                w.getId(),w.getId_utente(), w.getNome() );
        return rowAffected>0;
    }

    public boolean removeWishlist(String id){
        int rowAffected = db_vinted.update("delete from vinted.wishlist where id=?",id);
        return rowAffected>0;
    }

    public boolean updateWishlist(WishListModel w){
        int rowAffected = db_vinted.update("update vinted.wishlist set nome=?",
                w.getNome());
        return rowAffected>0;
    }

    public List<WishListModel> getWishlist(String id_utente){
        return this.db_vinted.query("select * from vinted.wishlist where id_utente=?",
                (rs, rowNum) ->
                        new WishListModel(
                                rs.getString("id"),
                                rs.getString("id_utente"),
                                rs.getString("nome")
                        )
                ,id_utente
        );
    }

    public List<WishListModel> getAllWishlists(){
        return this.db_vinted.query("select * from vinted.wishlist",
                (rs, rowNum) ->
                        new WishListModel(
                                rs.getString("id"),
                                rs.getString("nome"),
                                rs.getString("id_utente")
                        )
        );
    }


}
