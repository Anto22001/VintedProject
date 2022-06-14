package com.example.demo.service;

import com.example.demo.model.CategoriaModel;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    CategoriaRepository categoryRepo;

    @Autowired
    public CategoriaService(CategoriaRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public boolean createCategory(CategoriaModel c){
        return this.categoryRepo.createCategory(c);
    }

    public boolean removeCategory(String id){
        return this.categoryRepo.removeCategory(id);
    }

    public boolean updateCategory(CategoriaModel c){
        return this.categoryRepo.updateCategory(c);
    }
    public List<CategoriaModel> getCategorie(){
        return this.categoryRepo.getCategorie();
    }

}
