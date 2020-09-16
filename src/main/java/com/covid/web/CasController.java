package com.covid.web;

import com.covid.entities.Cas;
import com.covid.repositories.CasRepository;
import com.covid.service.CasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

public class CasController {

   /* @Autowired
    private CasRepository casRepository;
    @Autowired
    private CasService casService;

   @PostMapping
   public ResponseEntity add(@RequestBody Cas cas){
       return ResponseEntity.ok(Collections.singletonMap("Response", casService.addCas(cas)));
   }*/

  /* @GetMapping("/allCas-by-ville/{ville}")
    public ResponseEntity<Cas> ville(@PathVariable("ville") String ville){
       return new ResponseEntity<Cas>(casRepository.getAllCasByVille(ville), HttpStatus.OK);
   }*/
}
