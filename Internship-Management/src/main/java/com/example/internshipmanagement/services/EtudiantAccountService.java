package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtudiantDTO;

import java.util.List;

public interface EtudiantAccountService {
    EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO);

    List<EtudiantDTO> listEtudiant();

    EtudiantDTO getEtudiant(Long EtudiantId);

    EtudiantDTO updateEtudiant(EtudiantDTO etudiantDTO);

    void deleteEtudiant(Long EtudiantId);




}