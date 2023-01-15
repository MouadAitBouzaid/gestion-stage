package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.mappers.EtablissementMapperImpl;
import com.example.internshipmanagement.repositories.EtablissementRepository;
import com.example.internshipmanagement.repositories.EtudiantAccountRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EtablissementServiceImpl implements EtablissementService{
    private final EtudiantAccountRepository etudiantAccountRepository;
    private EtablissementRepository etablissementRepository;
    private EtablissementMapperImpl dtoMapper;



    @Override
    public EtablissementDTO saveEtablissemnt(EtablissementDTO etablissementDTO) {
        Etablissement etablissement = dtoMapper.fromeEtablissementDTO(etablissementDTO);
        Etablissement saveEtablissement = etablissementRepository.save(etablissement);
        return dtoMapper.fromEtablissement(saveEtablissement);
    }

    public EtablissementDTO saveEtablissementGlobal(Long etabId, String nameEtab ){
        Etablissement etablissement = etablissementRepository.findById(etabId).orElse(null);
       // List<Etudiant> etudiant = etudiantAccountRepository;


        return null;

    }
    @Override
    public List<EtablissementDTO> listEtablissement() {
       List<Etablissement> etablissements = etablissementRepository.findAll();

       List<EtablissementDTO> etablissementDTOS =etablissements.stream()
               .map(etablissement -> dtoMapper.fromEtablissement(etablissement))
               .collect(Collectors.toList());
       return etablissementDTOS;
    }

    @Override
    public EtablissementDTO getEtablissement(Long etablissementId) {
        Etablissement etablissement = etablissementRepository.findById(etablissementId).orElseThrow();
        return dtoMapper.fromEtablissement(etablissement);
    }

    @Override
    public EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTO) {
        log.info("Saving new School");
        Etablissement etablissement=dtoMapper.fromeEtablissementDTO(etablissementDTO);
        Etablissement savedEtablissement = etablissementRepository.save(etablissement);
        return dtoMapper.fromEtablissement(savedEtablissement);
    }

    @Override
    public void deleteEtablissement(Long EtablissementId) {
        etablissementRepository.deleteById(EtablissementId);
    }
}
