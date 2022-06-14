package com.example.demo.service;

import com.example.demo.model.AcquistoModel;
import com.example.demo.model.ArticoloModel;
import com.example.demo.repository.AcquistoRepository;
import com.example.demo.repository.ArticoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquistoService {
    AcquistoRepository acquistoRepo;
    ArticoloRepository articoloRepo;

    @Autowired
    public AcquistoService(AcquistoRepository acquistoRepo, ArticoloRepository articoloRepo) {
        this.acquistoRepo = acquistoRepo;
        this.articoloRepo = articoloRepo;
    }

    public boolean createAcquisto(AcquistoModel ac){
        for(ArticoloModel a : this.articoloRepo.getArticoli()) {
            if (a.getId().equals(ac.getId_articolo())) {
                if (ac.getData_acquisto().compareTo(a.getData_pubblicazione()) >= 0 && ac.getData_acquisto().compareTo(ac.getData_spedizione()) <= 0) {
                    a.setIn_vendita(false);
                    return this.acquistoRepo.createAcquisto(ac);
                }
            }
        }
        return false;
    }
    public boolean removeAcquisto(String id){ return this.acquistoRepo.removeAcquisto(id); }
    public List<AcquistoModel> getAcquisti(){ return this.acquistoRepo.getAcquisti(); }
}
