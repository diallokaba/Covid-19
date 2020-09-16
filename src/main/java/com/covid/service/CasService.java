package com.covid.service;

import com.covid.entities.Cas;
import com.covid.repositories.CasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RestController
@CrossOrigin("*")
public class CasService {

       @Autowired
        private CasRepository casRepository;

       @RequestMapping(value = "/coronas/cas", method = RequestMethod.GET)
       public List<Cas> getAll() {
           try {
               return casRepository.findAll();
           } catch (Exception e) {
               e.printStackTrace();
               return new ArrayList<>();
           }
       }

        @RequestMapping(value = "/corona/casparville", method = RequestMethod.GET)
        public List<Cas> getAllCasByVille(@RequestParam String ville){
            return casRepository.getAllCasByVille(ville);
        }

        @RequestMapping(value = "/corona/casparquartier", method = RequestMethod.GET)
        public List<Cas> getAllCasByQuartier(@RequestParam String quartier){
            return casRepository.getAllCasByQuartier(quartier);
        }

        //List Cas represente l'affichage de tous les cas
        // si non on pouvait passer par un int ou par un boolean
    @RequestMapping(value = "/corona/cas/save", method = RequestMethod.POST)
    public List<Cas> save(Cas cas, @RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
        cas.setDate(datecas);
        casRepository.save(cas);
        return casRepository.findAll();
    }

    //avec @PathVariable on utilise un / au lieu d'un ?
    // son url se presente comme suit: http://localhost:8089/corona/cas/delete/3
        @RequestMapping(value = "/corona/cas/delete/{id}", method = RequestMethod.DELETE)
        public List<Cas> delete(@PathVariable Long id){
            if(casRepository.getById(id) != null) {
                casRepository.delete(casRepository.getById(id));
            }
            return casRepository.findAll();
        }

        @RequestMapping(value = "/corona/cas/get", method = RequestMethod.GET)
        public Cas get(@RequestParam Long id){
            return casRepository.getById(id);
        }

        //url avec la methode PUT http://localhost:8089/corona/cas/update/2?datecas=2020-04-30
    @RequestMapping(value = "/corona/cas/update/{id}", method = RequestMethod.PUT)
    public List<Cas> update(@PathVariable Long id, Cas cas, @RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
        cas.setId(id);
        cas.setDate(datecas);
        casRepository.save(cas);
        return casRepository.findAll();
    }

}
