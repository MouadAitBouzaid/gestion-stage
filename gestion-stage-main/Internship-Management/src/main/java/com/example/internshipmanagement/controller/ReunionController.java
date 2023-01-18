package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.ReunionDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.Reunion;
import com.example.internshipmanagement.mappers.ReunionMapper;
import com.example.internshipmanagement.repositories.EtudiantRepository;
import com.example.internshipmanagement.repositories.ReunionRepository;
import com.example.internshipmanagement.services.ReunionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Transactional
@RestController
public class ReunionController {

    @Autowired
    private ReunionService reunionService;


    @GetMapping("/reunions/")
    public ResponseEntity<List<ReunionDTO>> findAll(){
        return ResponseEntity.ok(reunionService.findAll());
    }

    @PostMapping("/reunions/")
    public ResponseEntity<ReunionDTO> createReunion(@RequestBody ReunionDTO reunion) {
        return ResponseEntity.ok(reunionService.save(reunion));
    }

    @DeleteMapping("/reunions/{id}")
    public ResponseEntity<HttpStatus> deleteReunion(@PathVariable(value = "id") Long reunionId) {
        reunionService.deleteEtudiant(reunionId);
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @GetMapping("/reunions/{id}")
    public ResponseEntity<ReunionDTO> getReunion(@PathVariable(value = "id")Long reunionId){
        return ResponseEntity.ok(reunionService.getEtudiantById(reunionId).get());
    }



}


