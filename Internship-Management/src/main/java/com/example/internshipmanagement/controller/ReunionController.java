package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.ReunionDTO;
import com.example.internshipmanagement.entities.Reunion;
import com.example.internshipmanagement.mappers.ReunionMapper;
import com.example.internshipmanagement.repositories.ReunionRepository;
import com.example.internshipmanagement.services.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReunionController {

    @Autowired
    ReunionService reunionService;

    /*@GetMapping("/reunions/{id}")
    public ResponseEntity<ReunionDTO> findById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(reunionMapper.toDto(reunionRepository.findById(id).get()), HttpStatus.OK);
    }*/



    @GetMapping("/reunions/")
    public ResponseEntity<List<ReunionDTO>> findAll(){
        return ResponseEntity.ok(reunionService.findAll());
    }

    @PostMapping("/reunions/")
    public ResponseEntity<ReunionDTO> createReunion(@RequestBody ReunionDTO reunion) {
        return ResponseEntity.ok(reunionService.save(reunion));
    }

    /*@DeleteMapping("/reunions/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        ReunionDTO reunionDTO = reunionMapper.toDto(reunionRepository.findById(id).get());
        reunionRepository.deleteById(reunionDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

}
