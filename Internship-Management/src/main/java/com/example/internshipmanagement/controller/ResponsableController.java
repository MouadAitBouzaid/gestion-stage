package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.dtos.ResponsableStageDTO;
import com.example.internshipmanagement.entities.Professeur;
import com.example.internshipmanagement.entities.ResponsableStage;
import com.example.internshipmanagement.mappers.ResponsableMapper;
import com.example.internshipmanagement.repositories.ResponsableStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResponsableController {
    @Autowired
    private ResponsableMapper responsableMapper;
    @Autowired
    private ResponsableStageRepository responsableStageRepository;


    @PostMapping("/responsables/")
    public ResponseEntity<ResponsableStage> save(@RequestBody ResponsableStageDTO responsableStageDTO){
        return new ResponseEntity<>(responsableStageRepository.save(
                responsableMapper.fromDto(responsableStageDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/responsables/")
    public ResponseEntity<List<ResponsableStageDTO>> findAll(){
        return new ResponseEntity<>(responsableMapper.listToDtos(responsableStageRepository.findAll()),HttpStatus.OK);
    }


    @GetMapping("/responsables/{id}")
    public ResponseEntity<ResponsableStageDTO> findById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(responsableMapper.toDto(responsableStageRepository.findById(id).get()), HttpStatus.OK);
    }

    @PutMapping("/responsables/{id}")
    public ResponsableStageDTO updateResponsable(@PathVariable long id, @RequestBody ResponsableStageDTO responsableStageDTO) {
        ResponsableStage responsableStage = responsableStageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResponsableStage not found with id " + id));
        responsableMapper.updateEntityFromDto(responsableStageDTO, responsableStage);
        return responsableMapper.toDto(responsableStageRepository.save(responsableStage));
    }

    @DeleteMapping("/responsables/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        ResponsableStageDTO responsableStageDTO = responsableMapper.toDto(responsableStageRepository.findById(id).get());
        responsableStageRepository.deleteById(responsableStageDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
