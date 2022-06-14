package com.example.demo.service;

import com.example.demo.model.RecensioneUtenteModel;
import com.example.demo.repository.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecensioneService {
    RecensioneRepository rensioneRepo;

    @Autowired
    public RecensioneService(RecensioneRepository rensioneRepo) {
        this.rensioneRepo = rensioneRepo;
    }

    public boolean createRecensione(RecensioneUtenteModel r){
        return this.rensioneRepo.createRecensione(r);
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
}
