package com.example.demo.service;

import com.example.demo.model.AcquistoModel;
import com.example.demo.model.ArticoloModel;
import com.example.demo.model.RecensioneUtenteModel;
import com.example.demo.model.UtenteModel;
import com.example.demo.repository.AcquistoRepository;
import com.example.demo.repository.ArticoloRepository;
import com.example.demo.repository.RecensioneRepository;
import com.example.demo.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecensioneService {
    RecensioneRepository rensioneRepo;
    AcquistoRepository acquistoRepo;
    ArticoloRepository articoloRepo;
    UtenteRepository utenteRepo;

    @Autowired
    public RecensioneService(RecensioneRepository rensioneRepo, AcquistoRepository acquistoRepo, ArticoloRepository articoloRepo, UtenteRepository utenteRepo) {
        this.rensioneRepo = rensioneRepo;
        this.acquistoRepo = acquistoRepo;
        this.articoloRepo = articoloRepo;
        this.utenteRepo = utenteRepo;
    }

    public boolean createRecensione(RecensioneUtenteModel r){
        int count=0;
        for(AcquistoModel ac : this.acquistoRepo.getAcquisti()) {       //tra gli acquisti
            if (ac.getId_acquirente().equals(r.getId_recensore())) {    //se il recensore ha fatto un acquisto
                count++;
                for(ArticoloModel a : this.articoloRepo.getArticoli()){     //tra gli articoli
                    if (a.getId_venditore().equals(r.getId_recensito()) && a.getId().equals(ac.getId_articolo())) { //se il venditore corrisponde al recensito
                        count++;                                                                                    //e l'articolo è lo stesso acquistato
                        break;
                    }
                }
                break;
            }
        }
        if(count==2 && (r.getValutazione()>=0 && r.getValutazione()<6))     //e la valutazione è in un range
                return this.rensioneRepo.createRecensione(r);               //crea recensione
        return false;
    }

    public boolean removeRecensione(String id){
        return this.rensioneRepo.removeRecensione(id);
    }

    public boolean updateRecensione(RecensioneUtenteModel r){
        return this.rensioneRepo.updateRecensione(r);
    }
    public List<RecensioneUtenteModel> getRecensione(){
        return this.rensioneRepo.getRecensioni();
    }

    public List<Double> valutazioneMedia(String id_utente){
        for(UtenteModel u : utenteRepo.getUtenti()){
            if(u.getId().equals(id_utente)) {
                return this.rensioneRepo.valutazioneMedia(u);
            }
        }
        return null;
    }
}
