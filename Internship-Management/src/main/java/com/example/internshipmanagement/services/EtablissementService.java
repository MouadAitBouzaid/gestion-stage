package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.dtos.EtudiantDTO;

import java.util.List;

public interface EtablissementService {
    EtablissementDTO saveEtablissemnt(EtablissementDTO etablissementDTO);

    List<EtablissementDTO> listEtablissement();

    EtablissementDTO getEtablissement(Long EtablissementId);

    EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTO);

    void deleteEtablissement(Long EtablissementId);


}