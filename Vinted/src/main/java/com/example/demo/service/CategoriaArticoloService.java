package com.example.demo.service;

import com.example.demo.repository.CategoriaArticoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaArticoloService {
    CategoriaArticoloRepository cateArtRepo;

    @Autowired
    public CategoriaArticoloService(CategoriaArticoloRepository cateArtRepo) {
        this.cateArtRepo = cateArtRepo;
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
}
