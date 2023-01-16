package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.dtos.ReunionDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.entities.Reunion;
import com.example.internshipmanagement.mappers.ReunionMapper;
import com.example.internshipmanagement.repositories.ReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReunionController {
    @Autowired
    private ReunionMapper reunionMapper;
    @Autowired
    private ReunionRepository reunionRepository;


    @GetMapping("/reunions/{id}")
    public ResponseEntity<ReunionDTO> findById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(reunionMapper.toDto(reunionRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/reunions/")
    public ResponseEntity<Reunion> save(@RequestBody ReunionDTO reunionDTO){
        return new ResponseEntity<>(reunionRepository.save(
                reunionMapper.fromDto(reunionDTO)), HttpStatus.CREATED);
    }

    @DeleteMapping("/reunions/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        ReunionDTO reunionDTO = reunionMapper.toDto(reunionRepository.findById(id).get());
        reunionRepository.deleteById(reunionDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
