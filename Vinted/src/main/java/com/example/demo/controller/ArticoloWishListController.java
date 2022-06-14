package com.example.demo.controller;

import com.example.demo.service.ArticoloWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vinted")
public class ArticoloWishListController {
    ArticoloWishListService artWishServ;

    @Autowired
    public ArticoloWishListController(ArticoloWishListService artWishServ) {
        this.artWishServ = artWishServ;
    }

    @PostMapping("/creaAssociazioneArticoloWishList")
    public ResponseEntity<Void> associateArticoloWishlist(@RequestParam String id_articolo, String id_wishlist){
        boolean creato = this.artWishServ.associateArticoloWishlist(id_articolo, id_wishlist);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaArticoloWishList")
    public ResponseEntity<Void> removeArticoloWishlist(@RequestParam String id_articolo, String id_wishlist){
        boolean rimosso = this.artWishServ.removeArticoloWishlist(id_articolo, id_wishlist);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaArticoloWishList")
    public ResponseEntity<Void> updateArticoloWishlist(@RequestParam String new_a, String new_w, String id_articolo, String id_wishlist){
        boolean creato = this.artWishServ.updateArticoloWishlist(new_a, new_w, id_articolo, id_wishlist);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
