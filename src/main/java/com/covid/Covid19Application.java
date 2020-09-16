package com.covid;

import com.covid.entities.Cas;
import com.covid.repositories.CasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Covid19Application implements CommandLineRunner {

    @Autowired
    private CasRepository casRepository;
    public static void main(String[] args) {
        SpringApplication.run(Covid19Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cas cas = new Cas();
        cas.setVille("Test ville");
        cas.setQuartier("Test quartier");
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse("2020-04-28");
        cas.setDate(date);
        //casRepository.save(cas);
        casRepository.findAll().forEach(c->
                System.out.println(c.getVille() +  " " + c.getQuartier())
        );
    }
}
