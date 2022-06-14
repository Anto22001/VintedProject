package com.example.demo.controller;

import com.example.demo.model.RecensioneUtenteModel;
import com.example.demo.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class RecensioneController {
    RecensioneService recensioneServ;

    @Autowired
    public RecensioneController(RecensioneService recensioneServ) {
        this.recensioneServ = recensioneServ;
    }

    @PostMapping("/creaRecensione")
    public ResponseEntity<Void> createReview(@RequestBody RecensioneUtenteModel r){
        boolean creato = this.recensioneServ.createRecensione(r);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaRecensione")
    public ResponseEntity<Void> removeReview(@RequestParam String id){
        boolean rimosso = this.recensioneServ.removeRecensione(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaRecensione")
    public ResponseEntity<Void> updateReview(@RequestBody RecensioneUtenteModel r){
        boolean updated = this.recensioneServ.updateRecensione(r);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getRecensioni")
    public ResponseEntity<List<RecensioneUtenteModel>> getRecensioni(){
        List<RecensioneUtenteModel> ris = this.recensioneServ.getRecensione();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }

    @GetMapping("/getValutazioneMedia")
    public ResponseEntity<List<Double>> getValutazioneMedia(@RequestParam String id_utente){
        List<Double> ris = this.recensioneServ.valutazioneMedia(id_utente);
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
