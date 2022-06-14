package com.example.demo.controller;

import com.example.demo.model.UtenteModel;
import com.example.demo.model.WishListModel;
import com.example.demo.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class WishListController {
    WishListService wishListServ;

    @Autowired
    public WishListController(WishListService wishListServ) {
        this.wishListServ = wishListServ;
    }

    @PostMapping("/creaWishList")
    public ResponseEntity<Void> createWishList(@RequestBody WishListModel w){
        boolean creato = this.wishListServ.createWishList(w);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaWishList")
    public ResponseEntity<Void> removeWishList(@RequestParam String id){
        boolean rimosso = this.wishListServ.removeWishList(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaWishList")
    public ResponseEntity<Void> updateWishList(@RequestBody WishListModel w){
        boolean updated = this.wishListServ.updateWishList(w);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getWishList")
    public ResponseEntity<List<WishListModel>> getWishList(@RequestParam String id_utente){
        List<WishListModel> ris = this.wishListServ.getWishList(id_utente);
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
