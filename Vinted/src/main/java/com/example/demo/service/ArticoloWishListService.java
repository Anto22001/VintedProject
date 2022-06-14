package com.example.demo.service;

import com.example.demo.model.ArticoloModel;
import com.example.demo.repository.ArticoloWishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticoloWishListService {
    ArticoloWishListRepository artWishRepo;

    @Autowired
    public ArticoloWishListService(ArticoloWishListRepository artWishRepo) {
        this.artWishRepo = artWishRepo;
    }

    public boolean associateArticoloWishlist(String id_articolo, String id_wishlist){
        return this.artWishRepo.associateArticoloWishlist(id_articolo, id_wishlist);
    }

    public boolean removeArticoloWishlist(String id_articolo, String id_wishlist){
        return this.artWishRepo.removeArticoloWishlist(id_articolo, id_wishlist);
    }

    public boolean updateArticoloWishlist(String new_ida, String new_idw,String id_articolo, String id_wishlist){
        return this.artWishRepo.updateArticoloWishlist(new_ida, new_idw, id_articolo, id_wishlist);
    }

    /*public boolean removeArticoloFromEveryWishlists(ArticoloModel a){
        return this.artWishRepo.removeArticoloFromEveryWishlists(a);
    }*/
}
