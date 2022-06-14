package com.example.demo.service;

import com.example.demo.repository.CategoriaPreferitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaPreferitaService {
    CategoriaPreferitaRepository catePrefRepo;

    @Autowired
    public CategoriaPreferitaService(CategoriaPreferitaRepository catePrefRepo) {
        this.catePrefRepo = catePrefRepo;
    }

    public boolean associateCategoriaUtente(String id_cat, String id_utente){
        return this.catePrefRepo.associateCategoriaUtente(id_cat,id_utente);
    }

    public boolean removeCategoriaUtente(String id_cat, String id_utente){
        return this.catePrefRepo.removeCategoriaUtente(id_cat, id_utente);
    }

    public boolean updateCategoriaUtente(String new_idc, String new_idu,String id_cat, String id_utente){
        return this.catePrefRepo.updateCategoriaUtente(new_idc, new_idu, id_cat, id_utente);
    }
}
