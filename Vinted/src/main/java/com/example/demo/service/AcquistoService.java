package com.example.demo.service;

import com.example.demo.model.AcquistoModel;
import com.example.demo.model.ArticoloModel;
import com.example.demo.model.UtenteModel;
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
            if (a.getId().equals(ac.getId_articolo()) && !a.getId_venditore().equals(ac.getId_acquirente()) && a.isIn_vendita()) {
                if (ac.getData_acquisto().compareTo(a.getData_pubblicazione()) >= 0 && ac.getData_acquisto().compareTo(ac.getData_spedizione()) <= 0) {
                    a.setIn_vendita(false);
                    this.articoloRepo.updateArticolo(a);
                    this.artWishRepo.removeArticoloFromEveryWishlists(a);
                    return this.acquistoRepo.createAcquisto(ac);
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

    public List<AcquistoModel> getAcquistiUtente(String id_utente){ return this.acquistoRepo.getAcquistiUtente(id_utente); }
    public List<AcquistoModel> getAcquistiRangeTempo(int range){ return this.acquistoRepo.getAcquistiRangeTempo(range); }
}
