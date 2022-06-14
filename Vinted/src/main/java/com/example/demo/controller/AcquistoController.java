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
    public ResponseEntity<Void> removeAcquisto(@RequestParam String id){
        boolean rimosso = this.acquistoServ.removeAcquisto(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getAcquisti")
    public ResponseEntity<List<AcquistoModel>> getArticolo(){
        List<AcquistoModel> ris = this.acquistoServ.getAcquisti();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
