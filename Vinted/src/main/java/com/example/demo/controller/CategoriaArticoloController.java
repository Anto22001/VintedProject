package com.example.demo.controller;

import com.example.demo.model.ArticoloModel;
import com.example.demo.model.CategoriaModel;
import com.example.demo.service.CategoriaArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class CategoriaArticoloController {
    CategoriaArticoloService cateArtServ;

    @Autowired
    public CategoriaArticoloController(CategoriaArticoloService cateArtServ) {
        this.cateArtServ = cateArtServ;
    }

    @PostMapping("/creaAssociazioneCatArt")
    public ResponseEntity<Void> associateCategoriaArticolo(@RequestParam String id_categoria, String id_articolo){
        boolean creato = this.cateArtServ.associateCategoriaArticolo(id_categoria, id_articolo);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaCategoriaArticolo")
    public ResponseEntity<Void> removeCategoriaArticolo(@RequestParam String id_categoria, String id_articolo){
        boolean rimosso = this.cateArtServ.removeCategoriaArticolo(id_categoria, id_articolo);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaCategoriaArticolo")
    public ResponseEntity<Void> updateCategoriaArticolo(@RequestParam String new_c, String new_a, String id_categoria, String id_articolo){
        boolean creato = this.cateArtServ.updateCategoriaArticolo(new_c, new_a, id_categoria, id_articolo);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getArticoliCategoria")
    public ResponseEntity<List<ArticoloModel>> getArticoliCategoria(@RequestBody CategoriaModel c){
        List<ArticoloModel> ris = this.cateArtServ.getArticoliCategoria(c);
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
