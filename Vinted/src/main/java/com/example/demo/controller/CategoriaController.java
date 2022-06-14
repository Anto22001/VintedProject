package com.example.demo.controller;

import com.example.demo.model.CategoriaModel;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinted")
public class CategoriaController {
    CategoriaService categoriaServ;

    @Autowired
    public CategoriaController(CategoriaService categoriaServ) {
        this.categoriaServ = categoriaServ;
    }

    @PostMapping("/creaCategoria")
    public ResponseEntity<Void> createCategory(@RequestBody CategoriaModel c){
        boolean creato = this.categoriaServ.createCategory(c);
        return creato ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/cancellaCategoria")
    public ResponseEntity<Void> removeCategory(@RequestParam String id){
        boolean rimosso = this.categoriaServ.removeCategory(id);
        return rimosso ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/modificaCategoria")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoriaModel c){
        boolean updated = this.categoriaServ.updateCategory(c);
        return updated ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getCategorie")
    public ResponseEntity<List<CategoriaModel>> getCategorie(){
        List<CategoriaModel> ris = this.categoriaServ.getCategorie();
        return ResponseEntity.status(HttpStatus.OK).body(ris);
    }
}
