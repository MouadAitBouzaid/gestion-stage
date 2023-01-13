package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class EtudiantMapperImpl {

    public EtudiantDTO fromEtudiant(Etudiant etudiant){
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiant,etudiantDTO);
        return etudiantDTO;
    }

    public Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO){
        Etudiant etudiant=new Etudiant();
        BeanUtils.copyProperties(etudiantDTO,etudiant);
        return etudiant;
    }
}
