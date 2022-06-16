package com.example.demo.service;

import com.example.demo.model.AcquistoModel;
import com.example.demo.model.ArticoloModel;
import com.example.demo.model.WishListModel;
import com.example.demo.repository.AcquistoRepository;
import com.example.demo.repository.WishListRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

@Service
public class WishListService {
    WishListRepository wishlistRepo;
    AcquistoService acquistoServ;

    @Autowired
    public WishListService(WishListRepository wishlistRepo, AcquistoService acquistoServ) {
        this.wishlistRepo = wishlistRepo;
        this.acquistoServ = acquistoServ;
    }

    public boolean createWishList(WishListModel  w){ return this.wishlistRepo.createWishlist(w); }
    public boolean updateWishList(WishListModel w){ return this.wishlistRepo.updateWishlist(w); }
    public boolean removeWishList(String id){ return this.wishlistRepo.removeWishlist(id); }
    public List<WishListModel> getWishList(String id_utente){ return this.wishlistRepo.getWishlist(id_utente); }

    public List<WishListModel> getAllWishLists(){ return this.wishlistRepo.getAllWishlists(); }

    //carrello
    public boolean acquistaArticoliWishList(String[] id_articoli, String id_WishList){
        int r=(int) (Math.random() * (LocalDate.now().getMonth().maxLength() - LocalDate.now().getDayOfMonth())) + LocalDate.now().getDayOfMonth();
        LocalDate data_spedizione=LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),r);
        String user="";
        int count=0;
        for(WishListModel w : this.wishlistRepo.getAllWishlists()) {
            if (w.getId().equals(id_WishList)) {
                user = w.getId_utente();
                break;
            }
        }
        for(String id_a : id_articoli){
            if(this.acquistoServ.createAcquisto(new AcquistoModel(user,id_a,"",LocalDate.now(),data_spedizione)))
                count++;
        }
        return count == id_articoli.length;
    }
}
