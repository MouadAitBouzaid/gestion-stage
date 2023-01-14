package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.mappers.EtablissementMapperImpl;
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
public class EtudiantAccountServiceImpl implements EtudiantAccountService{
    private EtudiantAccountRepository etudiantAccountRepository;

    private EtablissementMapperImpl dtoMapper;

    @Override
    public EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO){
        Etudiant etudiant = dtoMapper.fromEtudiantDTO(etudiantDTO);
       Etudiant saveEtudiant = etudiantAccountRepository.save(etudiant);
       return dtoMapper.fromEtudiant(saveEtudiant);

    }

    @Override
    public List<EtudiantDTO> listEtudiant() {
        List<Etudiant> etudiants = etudiantAccountRepository.findAll();

        List<EtudiantDTO> etudiantDTOS = etudiants.stream()
                .map(etudiant -> dtoMapper.fromEtudiant(etudiant))
                .collect(Collectors.toList());
        return etudiantDTOS;
    }

    @Override
    public EtudiantDTO getEtudiant(Long etudiantId) {
        Etudiant etudiant = etudiantAccountRepository.findById(etudiantId).orElseThrow();
        return dtoMapper.fromEtudiant(etudiant);
    }


    @Override
    public EtudiantDTO updateEtudiant(EtudiantDTO etudiantDTO) {
        log.info("Saving new Customer");
        Etudiant etudiant=dtoMapper.fromEtudiantDTO(etudiantDTO);
        Etudiant savedEtudiant = etudiantAccountRepository.save(etudiant);
        return dtoMapper.fromEtudiant(savedEtudiant);
    }

    @Override
    public void deleteEtudiant(Long etudiantId) {
        etudiantAccountRepository.deleteById(etudiantId);
    }
}
