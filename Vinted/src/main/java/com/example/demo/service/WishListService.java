package com.example.demo.service;

import com.example.demo.model.WishListModel;
import com.example.demo.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
    WishListRepository wishlistRepo;

    @Autowired
    public WishListService(WishListRepository wishlistRepo) {
        this.wishlistRepo = wishlistRepo;
    }

    public boolean createWishList(WishListModel  w){ return this.wishlistRepo.createWishlist(w); }
    public boolean updateWishList(WishListModel w){ return this.wishlistRepo.updateWishlist(w); }
    public boolean removeWishList(String id){ return this.wishlistRepo.removeWishlist(id); }
    public List<WishListModel> getWishList(String id_utente){ return this.wishlistRepo.getWishlist(id_utente); }
}
