package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class VintedController {
    VintedService vintedService;
    @Autowired
    public VintedController(VintedService vintedService) {
        this.vintedService = vintedService;
    }

    //utente
    @PostMapping("/creaUtente")
    public ResponseEntity<Void> createUser(@RequestBody UtenteModel u){
        boolean creato = this.vintedService.createUser(u);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaUtente")
    public ResponseEntity<Void> removeUser(@RequestParam String id){
        boolean rimosso = this.vintedService.removeUser(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaUtente")
    public ResponseEntity<Void> updateUser(@RequestBody UtenteModel u){
        boolean updated = this.vintedService.updateUser(u);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getUtenti")
    public ResponseEntity<List<UtenteModel>> getUtenti(){
        List<UtenteModel> ris = this.vintedService.getUtenti();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }

    //categoria
    @PostMapping("/creaCategoria")
    public ResponseEntity<Void> createCategory(@RequestBody CategoriaModel c){
        boolean creato = this.vintedService.createCategory(c);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaCategoria")
    public ResponseEntity<Void> removeCategory(@RequestParam String id){
        boolean rimosso = this.vintedService.removeCategory(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaCategoria")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoriaModel c){
        boolean updated = this.vintedService.updateCategory(c);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getCategorie")
    public ResponseEntity<List<CategoriaModel>> getCategorie(){
        List<CategoriaModel> ris = this.vintedService.getCategorie();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }

    @PostMapping("/creaRecensione")
    public ResponseEntity<Void> createReview(@RequestBody RecensioneUtenteModel r){
        boolean creato = this.vintedService.createRecensione(r);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaRecensione")
    public ResponseEntity<Void> removeReview(@RequestParam String id){
        boolean rimosso = this.vintedService.removeRecensione(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaRecensione")
    public ResponseEntity<Void> updateReview(@RequestBody RecensioneUtenteModel r){
        boolean updated = this.vintedService.updateRecensione(r);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getRecensioni")
    public ResponseEntity<List<RecensioneUtenteModel>> getRecensioni(){
        List<RecensioneUtenteModel> ris = this.vintedService.getRecensione();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
