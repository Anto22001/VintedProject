package com.example.demo.service;

import com.example.demo.model.AcquistoModel;
import com.example.demo.model.ArticoloModel;
import com.example.demo.repository.AcquistoRepository;
import com.example.demo.repository.ArticoloRepository;
import com.example.demo.repository.ArticoloWishListRepository;
import com.example.demo.repository.CategoriaPreferitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquistoService {
    AcquistoRepository acquistoRepo;
    ArticoloRepository articoloRepo;
    ArticoloWishListRepository artWishRepo;

    @Autowired
    public AcquistoService(AcquistoRepository acquistoRepo, ArticoloRepository articoloRepo, ArticoloWishListRepository artWishRepo) {
        this.acquistoRepo = acquistoRepo;
        this.articoloRepo = articoloRepo;
        this.artWishRepo = artWishRepo;
    }

    public boolean createAcquisto(AcquistoModel ac){
        for(ArticoloModel a : this.articoloRepo.getArticoli()) {
            if (a.getId().equals(ac.getId_articolo())) {
                if (ac.getData_acquisto().compareTo(a.getData_pubblicazione()) >= 0 && ac.getData_acquisto().compareTo(ac.getData_spedizione()) <= 0) {
                    a.setIn_vendita(false);
                    if(this.artWishRepo.removeArticoloFromEveryWishlists(a)) return this.acquistoRepo.createAcquisto(ac);
                    else return false;
                }
            }
        }
        return false;
    }
    public boolean removeAcquisto(String id){
        for(AcquistoModel ac : acquistoRepo.getAcquisti()){
            for(ArticoloModel a : articoloRepo.getArticoli())
                if(ac.getId_articolo().equals(a.getId()))
                    a.setIn_vendita(true);
        }
        return this.acquistoRepo.removeAcquisto(id);
    }
    public List<AcquistoModel> getAcquisti(){ return this.acquistoRepo.getAcquisti(); }

    @Service
    public static class CategoriaPreferitaService {
        CategoriaPreferitaRepository catePrefRepo;

        @Autowired
        public CategoriaPreferitaService(CategoriaPreferitaRepository catePrefRepo) {
            this.catePrefRepo = catePrefRepo;
        }

        public boolean associateCategoriaUtente(String id_cat, String id_utente){
            return this.catePrefRepo.associateCategoriaUtente(id_cat, id_utente);
        }

        public boolean removeCategoriaUtente(String id_cat, String id_utente){
            return this.catePrefRepo.removeCategoriaUtente(id_cat, id_utente);
        }

        public boolean updateCategoriaUtente(String new_idc, String new_idu,String id_cat, String id_utente){
            return this.catePrefRepo.updateCategoriaUtente(new_idc, new_idu, id_cat, id_utente);
        }
    }
}
