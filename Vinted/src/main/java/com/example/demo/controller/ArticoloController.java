package com.example.demo.controller;

import com.example.demo.model.ArticoloModel;
import com.example.demo.model.UtenteModel;
import com.example.demo.service.ArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class ArticoloController {
    ArticoloService articoloServ;

    @Autowired
    public ArticoloController(ArticoloService articoloServ) {
        this.articoloServ = articoloServ;
    }

    @PostMapping("/creaArticolo")
    public ResponseEntity<Void> createArticolo(@RequestBody ArticoloModel a){
        boolean creato = this.articoloServ.createArticolo(a);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaArticolo")
    public ResponseEntity<Void> removeArticolo(@RequestParam String id){
        boolean rimosso = this.articoloServ.removeArticolo(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaArticolo")
    public ResponseEntity<Void> updateArticolo(@RequestBody ArticoloModel a){
        boolean updated = this.articoloServ.updateArticolo(a);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getArticoli")
    public ResponseEntity<List<ArticoloModel>> getArticolo(){
        List<ArticoloModel> ris = this.articoloServ.getArticolo();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }

    @GetMapping("/getGuadagno")
    public ResponseEntity<Double> getGuadagno(@RequestParam String id_utente){
        Double ris = this.articoloServ.getGuadagno(id_utente);
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
