package com.example.demo;

import com.example.demo.model.AcquistoModel;
import com.example.demo.service.AcquistoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

@SpringBootTest
public class AcquistoServiceTest {
    @Autowired
    AcquistoService acquistoServ;
    @Autowired
    JdbcTemplate db_vinted;

    @Test
    public void testCreateAcquisto(){
        LocalDate ld= LocalDate.parse("2022-06-18");
        AcquistoModel acq=new AcquistoModel("0002","1001","via cavo",LocalDate.parse("2022-06-15"),ld);
        this.acquistoServ.createAcquisto(acq);
        this.db_vinted.query("select * from vinted.acquisto",
                (rs,rowNum)->new AcquistoModel(
                        rs.getString("id_acquirente"),
                        rs.getString("id_articolo"),
                        rs.getString("modalita_spedizione"),
                        rs.getDate("data_acquisto").toLocalDate(),
                        rs.getDate("data_spedizione").toLocalDate()
                ));
    }
}
