package com.example.demo.controller;

import com.example.demo.model.AcquistoModel;
import com.example.demo.service.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class AcquistoController {
    AcquistoService acquistoServ;

    @Autowired
    public AcquistoController(AcquistoService acquistoServ) {
        this.acquistoServ = acquistoServ;
    }

    @PostMapping("/creaAcquisto")
    public ResponseEntity<Void> createAcquisto(@RequestBody AcquistoModel ac){
        boolean creato = this.acquistoServ.createAcquisto(ac);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaAcquisto")
    public ResponseEntity<Void> removeAcquisto(@RequestParam String id_articolo){
        boolean rimosso = this.acquistoServ.removeAcquisto(id_articolo);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getAcquisti")
    public ResponseEntity<List<AcquistoModel>> getAcquisto(){
        List<AcquistoModel> ris = this.acquistoServ.getAcquisti();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }

    @GetMapping("/getAcquistiUtente")
    public ResponseEntity<List<AcquistoModel>> getAcquistoUtente(@RequestParam String id_utente){
        List<AcquistoModel> ris = this.acquistoServ.getAcquistiUtente(id_utente);
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }

    @GetMapping("/getAcquistiRangeTempo")
    public ResponseEntity<List<AcquistoModel>> getAcquistoRangeTempo(@RequestParam int range){
        List<AcquistoModel> ris = this.acquistoServ.getAcquistiRangeTempo(range);
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
