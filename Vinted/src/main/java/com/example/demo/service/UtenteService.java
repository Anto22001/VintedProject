package com.example.demo.service;

import com.example.demo.model.UtenteModel;
import com.example.demo.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UtenteService {
    UtenteRepository utenteRepo;
    @Autowired
    public UtenteService(UtenteRepository utenteRepo) {
        this.utenteRepo = utenteRepo;
    }

    //utente
    public boolean createUser(UtenteModel u){
        if(LocalDate.now().getYear()-u.getData_nascita().getYear()>=16)
            return this.utenteRepo.createUser(u);
        return false;
    }

    public boolean removeUser(String id){
        return this.utenteRepo.removeUser(id);
    }

    public boolean updateUser(UtenteModel u){
        return this.utenteRepo.updateUser(u);
    }
    public List<UtenteModel> getUtenti(){
        return this.utenteRepo.getUtenti();
    }

    public List<UtenteModel> getUtente(String id_utente){ return this.utenteRepo.getUtente(id_utente);   }
}
