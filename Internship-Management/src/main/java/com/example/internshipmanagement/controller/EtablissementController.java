package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.mappers.EtablissementMapper;
import com.example.internshipmanagement.repositories.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EtablissementController {
    @Autowired
    private EtablissementMapper etablissementMapper;
    @Autowired
    private EtablissementRepository etablissementRepository;

    @PostMapping("/etablissements/")
    public ResponseEntity<Etablissement> save(@RequestBody EtablissementDTO etablissementDTO){
        return new ResponseEntity<>(etablissementRepository.save(
                etablissementMapper.fromDto(etablissementDTO)), HttpStatus.CREATED);
    }
    @GetMapping("/etablissements/")
    public ResponseEntity<List<EtablissementDTO>> findAll(){
        return new ResponseEntity<>(etablissementMapper.listToDtos(etablissementRepository.findAll()),HttpStatus.OK);
    }

    @GetMapping("/etablissements/{id}")

    public ResponseEntity<EtablissementDTO> findById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(etablissementMapper.toDto(etablissementRepository.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/etablissements/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        EtablissementDTO etablissementDTO = etablissementMapper.toDto(etablissementRepository.findById(id).get());
        etablissementRepository.deleteById(etablissementDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

