package com.example.internshipmanagement.web;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.services.EtablissementServiceImpl;
import com.example.internshipmanagement.services.EtudiantAccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class EtudiantRestController {

    private EtudiantAccountServiceImpl etudiantAccountService;


    @GetMapping("/etudiants")
    public List<EtudiantDTO> listerEtudiat(){
        return etudiantAccountService.listEtudiant();
    }


}
