package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.Professeur;
import com.example.internshipmanagement.mappers.ProfesseurMapper;
import com.example.internshipmanagement.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProfesseurController {
    @Autowired
    private ProfesseurMapper professeurMapper;
    @Autowired
    private ProfesseurRepository professeurRepository;


    @PostMapping("/professeurs/")
    public ResponseEntity<Professeur> save(@RequestBody ProfesseurDTO professeurDTO){
        return new ResponseEntity<>(professeurRepository.save(
                professeurMapper.fromDto(professeurDTO)), HttpStatus.CREATED);
    }
    @GetMapping("/professeurs/")
    public ResponseEntity<List<ProfesseurDTO>> findAll(){
        return new ResponseEntity<>(professeurMapper.listToDtos(professeurRepository.findAll()),HttpStatus.OK);
    }

    @PutMapping("/professeurs/{id}")
    public ProfesseurDTO updateProfesseur(@PathVariable long id, @RequestBody ProfesseurDTO professeurDTO) {
        Professeur professeur = professeurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professeur not found with id " + id));
        professeurMapper.updateEntityFromDto(professeurDTO, professeur);
        return professeurMapper.toDto(professeurRepository.save(professeur));
    }


    @GetMapping("/professeurs/{id}")
    public ResponseEntity<ProfesseurDTO> findById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(professeurMapper.toDto(professeurRepository.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/professeurs/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        ProfesseurDTO professeurDTO = professeurMapper.toDto(professeurRepository.findById(id).get());
        professeurRepository.deleteById(professeurDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
