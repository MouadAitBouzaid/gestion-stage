package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.mappers.EtudiantMapper;
import com.example.internshipmanagement.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants/")
public class EtudiantController {
     @Autowired
     private EtudiantMapper etudiantMapper;
     @Autowired
     private EtudiantRepository etudiantRepository;
    /*
     @PostMapping("/etudiants/")
     public ResponseEntity<Etudiant> save(@RequestBody EtudiantDTO etudiantDTO){
         return new ResponseEntity<>(etudiantRepository.save(
                 etudiantMapper.fromDto(etudiantDTO)), HttpStatus.CREATED);
     }
     */

    @PostMapping("")
    public Etudiant createEmployee(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    /*
    @GetMapping("/etudiants/")
    public List<Etudiant> getAllEmployees() {
        return etudiantRepository.findAll();
    }

     */

     @GetMapping("")
     public ResponseEntity<List<EtudiantDTO>> findAll(){
        return new ResponseEntity<>(etudiantMapper.listToDtos(etudiantRepository.findAll()),HttpStatus.OK);
     }

    @PutMapping("/{id}")
    public EtudiantDTO updateEtudiant(@PathVariable long id, @RequestBody EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found with id " + id));
        etudiantMapper.updateEntityFromDto(etudiantDTO, etudiant);
        return etudiantMapper.toDto(etudiantRepository.save(etudiant));
    }
     /*

    @PutMapping("/etudiants/{id}")
    public Etudiant updateEmployee(@PathVariable long id, @RequestBody Etudiant etudiant) {
        etudiant.setId(id);
        return etudiantRepository.save(etudiant);
    }

      */


    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> findById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(etudiantMapper.toDto(etudiantRepository.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        EtudiantDTO etudiantDTO = etudiantMapper.toDto(etudiantRepository.findById(id).get());
        etudiantRepository.deleteById(etudiantDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
