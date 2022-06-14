package com.example.demo.service;

import com.example.demo.model.ArticoloModel;
import com.example.demo.model.CategoriaModel;
import com.example.demo.repository.ArticoloRepository;
import com.example.demo.repository.CategoriaArticoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaArticoloService {
    CategoriaArticoloRepository cateArtRepo;
    ArticoloRepository artRepo;

    @Autowired
    public CategoriaArticoloService(CategoriaArticoloRepository cateArtRepo, ArticoloRepository artRepo) {
        this.cateArtRepo = cateArtRepo;
        this.artRepo = artRepo;
    }

    public boolean associateCategoriaArticolo(String id_cat, String id_art){
        return this.cateArtRepo.associateCategoriaArticolo(id_cat,id_art);
    }

    public boolean removeCategoriaArticolo(String id_cat, String id_art){
        return this.cateArtRepo.removeCategoriaArticolo(id_cat, id_art);
    }

    public boolean updateCategoriaArticolo(String new_idc, String new_ida,String id_cat, String id_art){
        return this.cateArtRepo.updateCategoriaArticolo(new_idc, new_ida, id_cat, id_art);
    }

    public List<ArticoloModel> getArticoliCategoria(CategoriaModel c){
        return this.cateArtRepo.getArticoliCategoria(c);
    }
}
