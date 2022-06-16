package com.example.demo;

import com.example.demo.model.ArticoloModel;
import com.example.demo.repository.ArticoloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

@SpringBootTest
public class ArticoloRepositoryTest {

    @Autowired
    ArticoloRepository articoloRepo;
    @Autowired
    JdbcTemplate db_vinted;

    @Test
    public void testCreateArticolo(){
        LocalDate ld = LocalDate.parse("2022-06-16");
        ArticoloModel art = new ArticoloModel("0005","Jeans Blu","Jeans blu belli","0002","Ottime",ld,"Catania",5.5,true);
        this.articoloRepo.createArticolo(art);
        this.db_vinted.query("select *from vinted.articolo" ,
                (rs,rowNum)-> new ArticoloModel(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("descrizione"),
                        rs.getString("id_venditore"),
                        rs.getString("condizioni"),
                        rs.getDate("data_pubblicazione").toLocalDate(),
                        rs.getString("luogo"),
                        rs.getDouble("prezzo"),
                        rs.getBoolean("in_vendita")
                ));
    }

    @Test
    public void testRemoveArticoli(){
        this.articoloRepo.removeArticolo("0005");
        this.db_vinted.query("select *from vinted.articolo" ,
                (rs,rowNum)-> new ArticoloModel(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("descrizione"),
                        rs.getString("id_venditore"),
                        rs.getString("condizioni"),
                        rs.getDate("data_pubblicazione").toLocalDate(),
                        rs.getString("luogo"),
                        rs.getDouble("prezzo"),
                        rs.getBoolean("in_vendita")
                ));
    }





}
