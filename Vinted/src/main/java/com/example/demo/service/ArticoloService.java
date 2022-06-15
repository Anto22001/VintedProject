package com.example.demo.service;

import com.example.demo.model.ArticoloModel;
import com.example.demo.model.RecensioneUtenteModel;
import com.example.demo.model.UtenteModel;
import com.example.demo.repository.ArticoloRepository;
import com.example.demo.repository.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticoloService {
    ArticoloRepository articoloRepo;

    @Autowired
    public ArticoloService(ArticoloRepository articoloRepo) {
        this.articoloRepo = articoloRepo;
    }

    public boolean createArticolo(ArticoloModel a){
        return this.articoloRepo.createArticolo(a);
    }

    public boolean removeArticolo(String id){
        return this.articoloRepo.removeArticolo(id);
    }

    public boolean updateArticolo(ArticoloModel a){
        return this.articoloRepo.updateArticolo(a);
    }
    public List<ArticoloModel> getArticolo(){
        return this.articoloRepo.getArticoli();
    }

    public List<ArticoloModel> articoliVenduti(String id_u){
        return this.articoloRepo.articoliVenduti(id_u);
    }

    public double getGuadagno(String u){ return this.articoloRepo.getGuadagno(u); }
}
