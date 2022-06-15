package com.example.demo.service;

import com.example.demo.model.RecensioneUtenteModel;
import com.example.demo.model.UtenteModel;
import com.example.demo.repository.RecensioneRepository;
import com.example.demo.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecensioneService {
    RecensioneRepository rensioneRepo;
    UtenteRepository utenteRepo;

    @Autowired
    public RecensioneService(RecensioneRepository rensioneRepo, UtenteRepository utenteRepo) {
        this.rensioneRepo = rensioneRepo;
        this.utenteRepo=utenteRepo;
    }

    public boolean createRecensione(RecensioneUtenteModel r){
        if(r.getValutazione()>=0 && r.getValutazione()<6)
            return this.rensioneRepo.createRecensione(r);
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
