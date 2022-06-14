package com.example.demo.controller;


import com.example.demo.service.CategoriaPreferitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vinted")
public class CategoriaPreferitaController {
    CategoriaPreferitaService catePrefServ;

    @Autowired
    public CategoriaPreferitaController(CategoriaPreferitaService catePrefServ) {
        this.catePrefServ = catePrefServ;
    }

    @PostMapping("/creaAssociazioneCatPref")
    public ResponseEntity<Void> associateCategoriaUtente(@RequestParam String id_categoria, String id_utente){
        boolean creato = this.catePrefServ.associateCategoriaUtente(id_categoria, id_utente);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaCategoriaPreferita")
    public ResponseEntity<Void> removeCategoriaUtente(@RequestParam String id_categoria, String id_utente){
        boolean rimosso = this.catePrefServ.removeCategoriaUtente(id_categoria, id_utente);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaCategoriaPreferita")
    public ResponseEntity<Void> updateCategoriaUtente(@RequestParam String new_c, String new_u, String id_categoria, String id_utente){
        boolean creato = this.catePrefServ.updateCategoriaUtente(new_c, new_u, id_categoria, id_utente);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
