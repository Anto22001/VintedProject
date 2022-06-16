package com.example.demo;

import com.example.demo.model.AcquistoModel;
import com.example.demo.repository.AcquistoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

@SpringBootTest
public class AcquistoRepositoryTest {
    @Autowired
    AcquistoRepository acquistoRepo;
    @Autowired
    JdbcTemplate db_vinted;

    @Test
    public void testCreateAcquisto(){
        LocalDate ld= LocalDate.parse("2022-06-18");
        AcquistoModel acq=new AcquistoModel("0002","1001","via cavo",LocalDate.parse("2022-06-15"),ld);
        this.acquistoRepo.createAcquisto(acq);
        this.db_vinted.query("select * from vinted.acquisto",
                (rs,rowNum)->new AcquistoModel(
                        rs.getString("id_acquirente"),
                        rs.getString("id_articolo"),
                        rs.getString("modalita_spedizione"),
                        rs.getDate("data_acquisto").toLocalDate(),
                        rs.getDate("data_spedizione").toLocalDate()
                ));
    }

    @Test
    public void testRemoveAcquisti(){
        this.acquistoRepo.removeAcquisto("1001");
        this.acquistoRepo.getAcquisti();
    }

    @Test
    public void testGetAcquisti(){
        this.db_vinted.update("insert into vinted.acquisto(id_acquirente,id_articolo,data_acquisto,modalita_spedizione,data_spedizione) values ('0002','1001',?,'cade dal cielo','2022-06-17');"
                ,LocalDate.now());
        this.acquistoRepo.getAcquisti();
    }

    @Test
     public void testGetAcquistiUtente(){
        this.db_vinted.update("insert into vinted.acquisto(id_acquirente,id_articolo,data_acquisto,modalita_spedizione,data_spedizione) values ('0002','1001',?,'cade dal cielo','2022-06-17');"
                ,LocalDate.now());
        this.acquistoRepo.getAcquistiUtente("0002");
    }

    @Test
    public void testGetAcquistiRangeTempo(){
        this.db_vinted.update("insert into vinted.acquisto(id_acquirente,id_articolo,data_acquisto,modalita_spedizione,data_spedizione) values ('0002','1001','2021-06-16','cade dal cielo','2022-06-17');");
        this.acquistoRepo.getAcquistiRangeTempo(12);
    }
}
