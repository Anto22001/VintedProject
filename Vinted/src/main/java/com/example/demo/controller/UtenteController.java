package com.example.demo.controller;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.RecensioneUtenteModel;
import com.example.demo.model.UtenteModel;
import com.example.demo.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class UtenteController {
    UtenteService utenteService;
    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PostMapping("/creaUtente")
    public ResponseEntity<Void> createUser(@RequestBody UtenteModel u){
        boolean creato = this.utenteService.createUser(u);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaUtente")
    public ResponseEntity<Void> removeUser(@RequestParam String id){
        boolean rimosso = this.utenteService.removeUser(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaUtente")
    public ResponseEntity<Void> updateUser(@RequestBody UtenteModel u){
        boolean updated = this.utenteService.updateUser(u);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getUtenti")
    public ResponseEntity<List<UtenteModel>> getUtenti(){
        List<UtenteModel> ris = this.utenteService.getUtenti();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
