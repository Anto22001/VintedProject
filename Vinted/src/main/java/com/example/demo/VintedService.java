package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VintedService {
    VintedRepository vintedRepo;
    @Autowired
    public VintedService(VintedRepository vintedRepo) {
        this.vintedRepo = vintedRepo;
    }

    //utente
    public boolean createUser(UtenteModel u){
        return this.vintedRepo.createUser(u);
    }

    public boolean removeUser(String id){
        return this.vintedRepo.removeUser(id);
    }

    public boolean updateUser(UtenteModel u){
        return this.vintedRepo.updateUser(u);
    }
    public List<UtenteModel> getUtenti(){
        return this.vintedRepo.getUtenti();
    }

    //categoria
    public boolean createCategory(CategoriaModel c){
        return this.vintedRepo.createCategory(c);
    }

    public boolean removeCategory(String id){
        return this.vintedRepo.removeCategory(id);
    }

    public boolean updateCategory(CategoriaModel c){
        return this.vintedRepo.updateCategory(c);
    }
    public List<CategoriaModel> getCategorie(){
        return this.vintedRepo.getCategorie();
    }

    //recensione
    public boolean createRecensione(RecensioneUtenteModel r){
        return this.vintedRepo.createRecensione(r);
    }

    public boolean removeRecensione(String id){
        return this.vintedRepo.removeRecensione(id);
    }

    public boolean updateRecensione(RecensioneUtenteModel r){
        return this.vintedRepo.updateRecensione(r);
    }
    public List<RecensioneUtenteModel> getRecensione(){
        return this.vintedRepo.getRecensioni();
    }
}
